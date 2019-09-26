package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionUtil;
import model.ReserveCan;
import model.User;

public class ReserveDAO implements IReserveDAO {
	ResultSet rs = null;
	PreparedStatement pst = null;
	Connection con = null;

	public void insertReserveStock(User user, ReserveCan reserveCan) {
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into reserve_info(user_reserve_id,cane_reserve) values(?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			pst.setInt(2, reserveCan.getCanReserve());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pst);
		}
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
