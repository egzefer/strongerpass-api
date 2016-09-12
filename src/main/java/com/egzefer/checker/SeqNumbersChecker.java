package com.egzefer.checker;

public class SeqNumbersChecker extends SequenceDeductionChecker {

	@Override
	protected boolean isExpectedCharType(int asciiCode) {
		return Character.isDigit(asciiCode);
	}

}
