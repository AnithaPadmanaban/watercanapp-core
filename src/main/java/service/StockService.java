package service;

import dao.StockDetailsDAO;
import exception.DBException;
import model.StockDetails;

public class StockService {
	StockDetailsDAO stockDetailsDAO = new StockDetailsDAO();

	public StockDetails viewAvailableStock() throws DBException {
		StockDetails stockDetails = null;
		try {
			stockDetails = stockDetailsDAO.viewStock();
		} catch (DBException e) {
			
			throw new DBException(e.getMessage());
		}
		return stockDetails;
	}
}
