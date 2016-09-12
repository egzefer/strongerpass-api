package com.egzefer;

import static com.egzefer.Status.EXCEPTIONAL;
import static com.egzefer.Status.SUFFICIENT;

import java.beans.Transient;

public class Requirement {

	private final Integer count;

	private final Integer bonus;

	private final Status status;

	public Requirement(Integer count, Integer bonus, Status status) {
		this.count = count;
		this.bonus = bonus;
		this.status = status;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getBonus() {
		return bonus;
	}

	public Status getStatus() {
		return status;
	}

	@Transient
	public Boolean isSufficient() {
		return SUFFICIENT.equals(this.status);
	}

	@Transient
	public Boolean isExceptional() {
		return EXCEPTIONAL.equals(this.status);
	}

	@Transient
	public Boolean isSufficientOrExceptional() {
		return this.isSufficient() || this.isExceptional();
	}

}
