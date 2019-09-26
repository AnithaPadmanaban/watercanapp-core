package service;

import dao.OrderDAO;
import loggerUtil.Logger;
import model.OrderCan;
import model.StockDetails;
import model.User;

public class OrderService {
	OrderDAO orderDAO = new OrderDAO();
	StockService stockService = new StockService();
	public static final Logger logger = Logger.getInstance();

	public void orderCan(User user, OrderCan order) {
		StockDetails availableStock = stockService.viewAvailableStock();
		int totalCanAfterOrder = 0;
		logger.debug(availableStock);
		if (order.getCanOrder() <= availableStock.getStockAvailability()) {
			orderDAO.orderStock(user, order);
			totalCanAfterOrder = availableStock.getStockAvailability() - order.getCanOrder();
			logger.info(totalCanAfterOrder);
			orderDAO.updateCan(totalCanAfterOrder);
		}
	}
}
