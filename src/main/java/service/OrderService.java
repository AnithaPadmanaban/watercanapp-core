package service;

import dao.OrderDAO;
import exception.DBException;
import loggerUtil.Logger;
import model.OrderCan;
import model.StockDetails;
import model.User;

public class OrderService {
	OrderDAO orderDAO = new OrderDAO();
	StockService stockService = new StockService();
	public static final Logger logger = Logger.getInstance();

	public void orderCan(User user, OrderCan order) throws DBException {
		StockDetails availableStock = stockService.viewAvailableStock();
		int totalCanAfterOrder = 0;
		logger.debug(availableStock);
		if (order.getCanOrder() <= availableStock.getStockAvailability()) {
			try {
				orderDAO.orderStock(user, order);
			} catch (DBException e) {
				throw new DBException(e.getMessage());
			}
			totalCanAfterOrder = availableStock.getStockAvailability() - order.getCanOrder();
			logger.info(totalCanAfterOrder);
			try {
				orderDAO.updateCan(totalCanAfterOrder);
			} catch (DBException e) {
				throw new DBException(e.getMessage());
			}
		} else {
			throw new DBException("Insufficient Order");
		}
	}
}
