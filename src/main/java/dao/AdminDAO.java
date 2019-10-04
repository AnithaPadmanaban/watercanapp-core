package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionUtil;
import exception.DBException;
import model.Admin;
import model.User;

public class AdminDAO implements IAdminDAO {
	ResultSet rs = null;
	PreparedStatement pst = null;
	Connection con = null;
	User user = new User();

	public Boolean adminLogin(Admin admin) throws DBException {
		Boolean result = false;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select admin_email,admin_password from admin_info where admin_email=? and admin_password=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, admin.getEmail());
			pst.setString(2, admin.getPassword());
			rs = pst.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			throw new DBException("Unable to login!!", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}
		return result;
	}

	public void updateCanByAdmin(int can) throws DBException {
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update stock_details set stock_availability=? where stock_id=1";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, can);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("Unable to update!!", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}
}
