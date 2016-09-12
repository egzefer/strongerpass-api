package com.egzefer.checker;

import com.egzefer.Requirement;

public class MidNumSymChecker extends AdditionChecker {

	private static final int BONUS_MULTIPLIER = 2;

	@Override
	public Requirement check(String password) {

		Integer count = 0;
		if (password.length() >= 3) {
			String removeEnds = password.substring(1, password.length() - 1);
			count = new Long(removeEnds.chars().filter(c -> !Character.isLetter(c)).count()).intValue();
		}
		Integer bonus = count * BONUS_MULTIPLIER;

		return new Requirement(count, bonus, getStatus(count));
	}

}
