package com.egzefer.checker;

import com.egzefer.Requirement;

public class ConsecLowercaseChecker extends DeductionChecker {

	private static final int BONUS_MULTIPLIER = 2;

	@Override
	public Requirement check(String password) {

		Integer count = 0;
		if (password.length() > 1) {
			for (int i = 1; i < password.length(); i++) {
				if (Character.isLowerCase(password.charAt(i)) && Character.isLowerCase(password.charAt(i - 1))) {
					count += 1;
				}
			}
		}
		Integer bonus = count * BONUS_MULTIPLIER * -1;

		return new Requirement(count, bonus, getStatus(count));
	}

}
