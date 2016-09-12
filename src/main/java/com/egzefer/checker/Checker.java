package com.egzefer.checker;

import com.egzefer.Requirement;
import com.egzefer.Status;

public abstract class Checker {

	public abstract Requirement check(String password);

	protected abstract boolean isExceptional(Integer count);

	protected abstract boolean isSufficient(Integer count);

	protected abstract boolean isWarning(Integer count);

	protected Status getStatus(Integer count) {

		if (isExceptional(count)) {
			return Status.EXCEPTIONAL;
		}

		if (isWarning(count)) {
			return Status.WARNING;
		}

		if (isSufficient(count)) {
			return Status.SUFFICIENT;
		}

		return Status.FAILURE;
	}
}
