package com.egzefer.checker;

public abstract class AdditionChecker extends Checker {

	@Override
	protected boolean isExceptional(Integer count) {
		return count >= 2;
	}

	@Override
	protected boolean isSufficient(Integer count) {
		return count >= 1;
	}

	@Override
	protected boolean isWarning(Integer count) {
		return false;
	}

}
