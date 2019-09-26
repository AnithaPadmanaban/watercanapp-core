package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionUtil;
import model.OrderCan;
import model.User;

public class OrderDAO implements IOrderDAO {
	ResultSet rs = null;
	PreparedStatement pst = null;
	Connection con = null;
	User user = new User();

	public void orderStock(User user, OrderCan can) { /// method is used to insert userid and can ordered in DB

		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into order_info(user_order_id,cane_order) values(?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			pst.setInt(2, can.getCanOrder());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}

	public void updateCan(int totalCanOrder) {
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update stock_details set stock_availability=? where stock_id=1";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, totalCanOrder);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pst);
		}
	}
}
