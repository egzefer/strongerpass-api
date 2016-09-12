package com.egzefer.checker;

import com.egzefer.Requirement;

public class UppercaseChecker extends AdditionChecker {

	private static final int BONUS_MULTIPLIER = 2;

	@Override
	public Requirement check(String password) {

		Integer count = new Long(password.chars().filter(c -> Character.isUpperCase(c)).count()).intValue();
		Integer bonus = count > 0 ? (password.length() - count) * BONUS_MULTIPLIER : 0;

		return new Requirement(count, bonus, getStatus(count));
	}

}
