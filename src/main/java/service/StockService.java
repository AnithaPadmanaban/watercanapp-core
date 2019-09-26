package service;

import dao.StockDetailsDAO;
import model.StockDetails;

public class StockService {
	StockDetailsDAO stockDetailsDAO = new StockDetailsDAO();

	public StockDetails viewAvailableStock() {
		StockDetails stockDetails = stockDetailsDAO.viewStock();
		return stockDetails;
	}
}
