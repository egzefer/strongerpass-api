package com.egzefer.checker;

public class SeqSymbolsChecker extends SequenceDeductionChecker {

	@Override
	protected boolean isExpectedCharType(int asciiCode) {
		return !Character.isLetter(asciiCode) && !Character.isDigit(asciiCode);
	}

}
