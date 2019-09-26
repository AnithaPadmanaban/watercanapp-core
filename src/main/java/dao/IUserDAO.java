package dao;

import model.User;

public interface IUserDAO {
	public int login(User user);

	public void register(User user);
}
