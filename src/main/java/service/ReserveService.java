package service;

import dao.ReserveDAO;
import loggerUtil.Logger;
import model.ReserveCan;
import model.StockDetails;
import model.User;

public class ReserveService {
	ReserveDAO reserveDAO = new ReserveDAO();
	StockService stockService = new StockService();
	public static final Logger logger = Logger.getInstance();

	public void reserveCanDetail(User user, ReserveCan reserveCan) {
		StockDetails availableStock = stockService.viewAvailableStock();
		int totalCanAfterReserve = 0;
		if (reserveCan.getCanReserve() <= availableStock.getStockAvailability()) {
			reserveDAO.insertReserveStock(user, reserveCan);
			totalCanAfterReserve = availableStock.getStockAvailability() - reserveCan.getCanReserve();
			logger.info(totalCanAfterReserve);
			reserveDAO.updateCan(totalCanAfterReserve);
		}
	}
}
