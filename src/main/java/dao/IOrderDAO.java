package dao;

import model.OrderCan;
import model.User;

public interface IOrderDAO {
	public void orderStock(User user, OrderCan can);

	public void updateCan(int totalCanOrder);

}
