package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionUtil;
import exception.DBException;
import model.User;

public class UserDAO implements IUserDAO {
	ResultSet rs = null;
	PreparedStatement pst = null;
	Connection con = null;
	User user = new User();

	public int login(User user) throws DBException {
		int userId = 0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select user_id,user_email,user_password from user_info where user_email=? and user_password=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			rs = pst.executeQuery();
			if (rs.next()) {
				userId = rs.getInt("user_id");
			}
		} catch (SQLException e) {
			throw new DBException("Unable to login", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}
		return userId;
	}

	public void register(User user) throws DBException { /// method is used to
		/// insert registration
		/// details into DB
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into user_info(user_name,user_password,user_email,user_address) values(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getAddress());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("Unable to reister", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}
}
