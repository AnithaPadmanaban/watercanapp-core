package dao;

import exception.DBException;
import model.StockDetails;

public interface IStockDetailsDAO {

	public StockDetails viewStock() throws DBException;
}
