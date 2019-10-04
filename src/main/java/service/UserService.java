package service;

import dao.UserDAO;
import exception.DBException;
import loggerUtil.Logger;
import model.User;

public class UserService {
	public static final Logger logger = Logger.getInstance();
	UserDAO userDAO = new UserDAO();

	public void registerProcess(User user) throws DBException {
		try {
			userDAO.register(user);
		} catch (DBException e) {
			
			throw new DBException(e.getMessage());
		}
	}

	public int loginProcess(User user) throws DBException {
		int userId = 0;
		try {
			userId = userDAO.login(user);
		} catch (DBException e) {
			
			throw new DBException(e.getMessage());
		}
		logger.info(userId);
		return userId;
	}
}
