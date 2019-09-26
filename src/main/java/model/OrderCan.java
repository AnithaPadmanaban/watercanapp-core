package model;

import java.time.LocalDate;

public class OrderCan {

	private int orderId;
	private int userOrderId;
	private int canOrder;
	private LocalDate orderedDate;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserOrderId() {
		return userOrderId;
	}

	public void setUserOrderId(int userOrderId) {
		this.userOrderId = userOrderId;
	}

	public int getCanOrder() {
		return canOrder;
	}

	public void setCanOrder(int canOrder) {
		this.canOrder = canOrder;
	}

	public LocalDate getOrderedDate() {
		return orderedDate;
	}

	public void setOrdered_date(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}
}
