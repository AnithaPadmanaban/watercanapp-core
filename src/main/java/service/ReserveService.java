package service;

import dao.OrderDAO;
import dao.ReserveDAO;
import exception.DBException;
import loggerUtil.Logger;
import model.ReserveCan;
import model.StockDetails;
import model.User;

public class ReserveService {
	ReserveDAO reserveDAO = new ReserveDAO();
	OrderDAO orderDAO = new OrderDAO();
	StockService stockService = new StockService();
	public static final Logger logger = Logger.getInstance();

	public int reserveCanDetail(User user, ReserveCan reserveCan) throws Exception {
		StockDetails availableStock = stockService.viewAvailableStock();
		int totalCanAfterReserve = 0;
		int reserveId = reserveDAO.getReserveID(user);

		if (reserveCan.getCanReserve() <= availableStock.getStockAvailability()) {

			if (reserveId == 0) {
				reserveId = reserveDAO.insertReserveStock(user, reserveCan);
				totalCanAfterReserve = availableStock.getStockAvailability() - reserveCan.getCanReserve();
				logger.info(totalCanAfterReserve);
				reserveDAO.updateCan(totalCanAfterReserve);
			} else if (reserveId != 0) {
				System.out.println("Updated");
				int userId = user.getUserId();
				int reserveCanValue = reserveDAO.getReserveCans(userId);
				System.out.println("reservecan" + reserveCanValue);
				int totalCanReserve = reserveCanValue + reserveCan.getCanReserve();
				System.out.println("totalCanResrve!!!!!!!" + totalCanReserve);
				reserveId = reserveDAO.updateReserveStock(user, totalCanReserve);
				totalCanAfterReserve = availableStock.getStockAvailability() - reserveCan.getCanReserve();
				System.out.println("total can after resrve))))))))" + totalCanAfterReserve);
				reserveDAO.updateCan(totalCanAfterReserve);
			}

		} else {
			throw new Exception("Insufficient Order");
		}
		return reserveId;
	}

	public void orderReservedCan(User user, ReserveCan reserveCan) throws DBException {

		int reserveId = reserveDAO.getReserveID(user);
		if (reserveId == reserveCan.getReserveId()) {
			int userId = user.getUserId();
			int reserveCanValue = reserveDAO.getReserveCans(userId);
			orderDAO.orderReservedStock(user, reserveCanValue);
			reserveDAO.deleteModifiedReserveOrder(userId);
		} else {
			throw new DBException("Invalid ReserveId");
		}
	}

	public void orderModifiedCan(User user, ReserveCan reserveCan) throws DBException {
		int userId = user.getUserId();
		System.out.println("User id is---"+userId);
		int reserveCanValue = reserveDAO.getReserveCans(userId);
		System.out.println("ReservedCanValue="+reserveCanValue);
		System.out.println("User resere can"+reserveCan.getCanReserve());
		if (reserveCan.getCanReserve() < reserveCanValue) {
			orderDAO.orderModifiedReservedCan(user, reserveCan);
			int totalCanAfterModified = reserveCanValue - reserveCan.getCanReserve();
			StockDetails availableStock = stockService.viewAvailableStock();
			int totalCanUpdate=totalCanAfterModified+availableStock.getStockAvailability();
			orderDAO.updateCan(totalCanUpdate);
			reserveDAO.deleteModifiedReserveOrder(userId);
		} else {
			throw new DBException("Input value is  greater than the reserved water-can..Please enter valid input");
		}
	}
}
