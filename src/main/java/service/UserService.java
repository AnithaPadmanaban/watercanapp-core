package service;

import dao.UserDAO;
import loggerUtil.Logger;
import model.User;

public class UserService {
	public static final Logger logger = Logger.getInstance();
	UserDAO userDAO = new UserDAO();

	public void registerProcess(User user) {
		userDAO.register(user);
	}

	public int loginProcess(User user) {
		int userId = userDAO.login(user);
		logger.info(userId);
		return userId;
	}
}
