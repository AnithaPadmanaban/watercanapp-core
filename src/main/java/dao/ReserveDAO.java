package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionUtil;
import exception.DBException;
import model.ReserveCan;
import model.User;

public class ReserveDAO implements IReserveDAO {
	ResultSet rs = null;
	PreparedStatement pst = null;
	Connection con = null;

	public int insertReserveStock(User user, ReserveCan reserveCan) throws DBException {
		int reservedId=0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into reserve_info(user_reserve_id,cane_reserve) values(?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			pst.setInt(2, reserveCan.getCanReserve());
			pst.executeUpdate();
		 reservedId=getReserveID(user);
		} catch (SQLException e) {
			throw new DBException("Unable to reserve",e);
		} finally {
			ConnectionUtil.close(con, pst);
		}
		return reservedId;
	}
	
	public int updateReserveStock(User user, int reserveCan) {
		int reservedId=0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update reserve_info set cane_reserve=? where user_reserve_id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1,reserveCan );
			pst.setInt(2, user.getUserId());
			pst.executeUpdate();
		 reservedId=getReserveID(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pst);
		}
		return reservedId;
	}
	
	
	

	public int getReserveID(User user) {
		int reserveId = 0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select reserve_id from reserve_info where user_reserve_id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUserId());

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				reserveId = rs.getInt("reserve_id");

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(con, pst);
		}
		return reserveId;

	}
	
	
	public int getReserveCans(int userId) {
		int reserveCan = 0;
		try {
			System.out.println("method is called");
			con = ConnectionUtil.getConnection();
			String sql = "select cane_reserve from reserve_info where user_reserve_id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				reserveCan = rs.getInt("cane_reserve");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(con, pst);
		}
		return reserveCan;

	}

	public void updateCan(int totalCanReserve) {
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update stock_details set stock_availability=? where stock_id=1";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, totalCanReserve);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}
}
