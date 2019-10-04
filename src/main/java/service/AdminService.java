package service;

import dao.AdminDAO;
import dao.StockDetailsDAO;
import exception.DBException;
import loggerUtil.Logger;
import model.Admin;
import model.StockDetails;

public class AdminService {
	AdminDAO adminDAO = new AdminDAO();
	StockDetailsDAO stockDetailsDAO = new StockDetailsDAO();
	public static final Logger logger = Logger.getInstance();

	public boolean adminLoginProcess(Admin admin) throws DBException {
		Boolean value = false;
		try {
			value = adminDAO.adminLogin(admin);
		} catch (DBException e) {
			
			throw new DBException(e.getMessage());
		}
		logger.info(value);
		return value;
	}

	public void updateCanByAdmin(int can) throws DBException {
		StockDetails stockDetails;
		stockDetails = stockDetailsDAO.viewStock();
		int updateCan = can + stockDetails.getStockAvailability();
		logger.info(updateCan);
		try {
			adminDAO.updateCanByAdmin(updateCan);
		} catch (DBException e) {
			
			throw new DBException(e.getMessage());
		}
	}
}
