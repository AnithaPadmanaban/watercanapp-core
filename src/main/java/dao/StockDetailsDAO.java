package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionUtil;
import model.StockDetails;
import model.User;

public class StockDetailsDAO implements IStockDetailsDAO {
	ResultSet rs = null;
	PreparedStatement pst = null;
	Connection con = null;
	User user = new User();

	public StockDetails viewStock() { /// method is used to view available stock from DB
		StockDetails stockDetails = new StockDetails();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from stock_details";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				stockDetails.setStockAvailability(rs.getInt("stock_availability"));
				Date date = rs.getDate("inserted_date");
				stockDetails.setStockAddedDate(date.toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(con, pst);
		}
		return stockDetails;
	}
}
