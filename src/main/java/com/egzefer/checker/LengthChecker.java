package com.egzefer.checker;

import com.egzefer.Requirement;

public class LengthChecker extends AdditionChecker {

	private static final int BONUS_MULTIPLIER = 4;

	@Override
	public Requirement check(String password) {

		Integer count = password.length();
		Integer bonus = count * BONUS_MULTIPLIER;

		return new Requirement(count, bonus, getStatus(count));
	}

	@Override
	protected boolean isExceptional(Integer count) {
		return count > 8;
	}

	@Override
	protected boolean isSufficient(Integer count) {
		return count >= 8;
	}

}
