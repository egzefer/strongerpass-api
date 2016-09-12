package com.egzefer.checker;

import com.egzefer.Requirement;

public class NumbersChecker extends AdditionChecker {

	private static final int BONUS_MULTIPLIER = 4;

	@Override
	public Requirement check(String password) {

		Integer count = new Long(password.chars().filter(c -> Character.isDigit(c)).count()).intValue();
		Integer bonus = password.length() > count ? count * BONUS_MULTIPLIER : 0;

		return new Requirement(count, bonus, getStatus(count));
	}

}
