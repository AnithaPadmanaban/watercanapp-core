package dao;

import exception.DBException;
import model.ReserveCan;
import model.User;

public interface IReserveDAO {
	public int insertReserveStock(User user, ReserveCan reserveCan) throws DBException;

	public int updateReserveStock(User user, int reserveCan);

	public int getReserveID(User user);

	public int getReserveCans(int userId);

	public void updateCan(int totalCanReserve) throws DBException;
}
