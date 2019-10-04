package dao;

import exception.DBException;
import model.User;

public interface IUserDAO {
	public int login(User user) throws DBException;

	public void register(User user) throws DBException;
}
