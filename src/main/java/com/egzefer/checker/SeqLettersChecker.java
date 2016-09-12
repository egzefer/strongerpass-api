package com.egzefer.checker;

public class SeqLettersChecker extends SequenceDeductionChecker {

	@Override
	protected boolean isExpectedCharType(int asciiCode) {
		return Character.isLetter(asciiCode);
	}

}
