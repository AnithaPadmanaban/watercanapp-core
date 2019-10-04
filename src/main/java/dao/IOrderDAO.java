package dao;

import exception.DBException;
import model.OrderCan;
import model.User;

public interface IOrderDAO {
	public void orderStock(User user, OrderCan can) throws DBException;

	public void updateCan(int totalCanOrder) throws DBException;

	public void orderReservedStock(User user, int reserveCanValue) throws DBException;
}
