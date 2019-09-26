package model;

import java.time.LocalDate;

public class StockDetails {

	private int stockId;
	private int stockAvailability;
	private LocalDate stockAddedDate;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getStockAvailability() {
		return stockAvailability;
	}

	public void setStockAvailability(int stockAvailability) {
		this.stockAvailability = stockAvailability;
	}

	public LocalDate getStockAddedDate() {
		return stockAddedDate;
	}

	public void setStockAddedDate(LocalDate stockAddedDate) {
		this.stockAddedDate = stockAddedDate;
	}
}
