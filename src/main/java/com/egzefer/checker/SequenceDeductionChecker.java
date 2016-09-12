package com.egzefer.checker;

import java.util.HashSet;

import com.egzefer.Requirement;

public abstract class SequenceDeductionChecker extends DeductionChecker {

	private static final int BONUS_MULTIPLIER = 3;

	protected abstract boolean isExpectedCharType(int character);

	@Override
	public Requirement check(String password) {

		Integer count = 0;

		int asciiCode = 0;
		int previousAsciiCode = 0;
		int numSeqCount = 1;
		char charArray[] = password.toLowerCase().toCharArray();
		HashSet<Integer> countedChars = new HashSet<Integer>();

		for (int i = 0; i < charArray.length; i++) {
			asciiCode = charArray[i];
			if (isExpectedCharType(asciiCode) && (previousAsciiCode + 1) == asciiCode) {
				numSeqCount++;
				if (!countedChars.contains(asciiCode) && numSeqCount > 2) {
					count += 1;
				}
				countedChars.add(asciiCode);
			} else {
				numSeqCount = 1;
			}
			previousAsciiCode = asciiCode;
		}

		Integer bonus = count * BONUS_MULTIPLIER * -1;

		return new Requirement(count, bonus, getStatus(count));
	}
}
