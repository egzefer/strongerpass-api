package com.egzefer.checker;

public abstract class DeductionChecker extends Checker {

	@Override
	protected boolean isExceptional(Integer count) {
		return false;
	}

	@Override
	protected boolean isSufficient(Integer count) {
		return count == 0;
	}

	@Override
	protected boolean isWarning(Integer count) {
		return count > 0;
	}
}
