package dao;

import model.ReserveCan;
import model.User;

public interface IReserveDAO {
	public void insertReserveStock(User user, ReserveCan reserveCan);

	public void updateCan(int totalCanOrder);
}
