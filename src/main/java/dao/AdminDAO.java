package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionUtil;
import model.Admin;
import model.User;

public class AdminDAO implements IAdminDAO {
	ResultSet rs = null;
	PreparedStatement pst = null;
	Connection con = null;
	User user = new User();

	public Boolean adminLogin(Admin admin) {
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
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pst);
		}
		return result;
	}

	public void updateCanByAdmin(int can) {
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update stock_details set stock_availability=? where stock_id=1";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, can);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}
}
