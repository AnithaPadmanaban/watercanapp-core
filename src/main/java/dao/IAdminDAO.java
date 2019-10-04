package dao;

import exception.DBException;
import model.Admin;

public interface IAdminDAO {
	public Boolean adminLogin(Admin admin) throws DBException;

	public void updateCanByAdmin(int can) throws DBException;
}
