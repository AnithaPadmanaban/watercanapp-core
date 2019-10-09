package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionUtil;
import exception.DBException;
import model.OrderCan;
import model.ReserveCan;
import model.User;

public class OrderDAO implements IOrderDAO {
	ResultSet rs = null;
	PreparedStatement pst = null;
	Connection con = null;
	User user = new User();

	public void orderStock(User user, OrderCan can) throws DBException { /// method is used to insert userid and can
																			/// ordered in DB

		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into order_info(user_order_id,cane_order) values(?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			pst.setInt(2, can.getCanOrder());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("Unable to order", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}

	public void orderReservedStock(User user, int reserveCanValue) throws DBException { /// method is used to insert
																						/// userid and can ordered in DB

		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into order_info(user_order_id,cane_order) values(?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			pst.setInt(2, reserveCanValue);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("Unable to order", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}

	public void updateCan(int totalCanOrder) throws DBException {
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update stock_details set stock_availability=? where stock_id=1";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, totalCanOrder);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("Unable to order", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}

	public void orderModifiedReservedCan(User user, ReserveCan reserveCan) throws DBException {

		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into order_info(user_order_id,cane_order) values(?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			pst.setInt(2, reserveCan.getCanReserve());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("Unable to order", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}
}
