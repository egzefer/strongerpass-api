package com.egzefer.checker;

import com.egzefer.Requirement;

public class NumbersOnlyChecker extends DeductionChecker {

	@Override
	public Requirement check(String password) {

		Integer count = new Long(password.chars().filter(c -> Character.isDigit(c)).count()).intValue();
		if (password.length() > count) {
			count = 0;
		}
		Integer bonus = count * -1;

		return new Requirement(count, bonus, getStatus(count));
	}

}
