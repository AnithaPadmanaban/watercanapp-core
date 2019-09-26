package service;

import dao.AdminDAO;
import dao.StockDetailsDAO;
import loggerUtil.Logger;
import model.Admin;
import model.StockDetails;

public class AdminService {
	AdminDAO adminDAO = new AdminDAO();
	StockDetailsDAO stockDetailsDAO = new StockDetailsDAO();
	public static final Logger logger = Logger.getInstance();

	public boolean adminLoginProcess(Admin admin) {
		Boolean value = adminDAO.adminLogin(admin);
		logger.info(value);
		return value;
	}

	public void updateCanByAdmin(int can) {
		StockDetails stockDetails;
		stockDetails = stockDetailsDAO.viewStock();
		int updateCan = can + stockDetails.getStockAvailability();
		logger.info(updateCan);
		adminDAO.updateCanByAdmin(updateCan);
	}
}
