package model;

import java.time.LocalDate;

public class ReserveCan {

	private Integer reserveId;
	private Integer userReserveId;
	private Integer canReserve;
	private LocalDate reserveDate;

	public Integer getReserveId() {
		return reserveId;
	}

	public void setReserveId(Integer reserveId) {
		this.reserveId = reserveId;
	}

	public Integer getUserReserveId() {
		return userReserveId;
	}

	public void setUserReserveId(Integer userReserveId) {
		this.userReserveId = userReserveId;
	}

	public Integer getCanReserve() {
		return canReserve;
	}

	public void setCanReserve(Integer canReserve) {
		this.canReserve = canReserve;
	}

	public LocalDate getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(LocalDate reserveDate) {
		this.reserveDate = reserveDate;
	}
}
