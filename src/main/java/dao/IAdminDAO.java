package dao;

import model.Admin;

public interface IAdminDAO {
	public Boolean adminLogin(Admin admin);

	public void updateCanByAdmin(int can);
}
