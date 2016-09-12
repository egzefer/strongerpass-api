package com.egzefer.checker;

import com.egzefer.Requirement;

public class SymbolsChecker extends AdditionChecker {

	private static final int BONUS_MULTIPLIER = 6;

	@Override
	public Requirement check(String password) {

		Integer count = new Long(password.chars().filter(c -> !Character.isLetterOrDigit(c)).count()).intValue();
		Integer bonus = count * BONUS_MULTIPLIER;

		return new Requirement(count, bonus, getStatus(count));
	}

}
