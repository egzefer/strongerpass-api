package com.egzefer.checker;

import java.util.Arrays;
import java.util.List;

import com.egzefer.Requirement;
import com.egzefer.dto.PasswordDTO;

/**
 * Validates whether or not the minimum of {@link MIN_COUNT} requirements has
 * been reached, by the following rule:
 * 
 * Minimum Requirements
 * - Minimum 8 characters in length
 * - Contains 3/4 of the following items:
 *   - Uppercase Letters
 *   - Lowercase Letters
 *   - Numbers
 *   - Symbols
 * 
 * @author evandro
 *
 */
public class TotalRequirementsChecker extends AdditionChecker {

	private static final int MIN_COUNT = 4;

	private static final int BONUS_MULTIPLIER = 2;

	/**
	 * Used to check one of the two main Requirements: password length
	 */
	private Requirement lengthReq;

	/**
	 * Used to check the second main Requirement, witch is divided in four: -
	 * Uppercase Letters - Lowercase Letters - Numbers - Symbols
	 * 
	 * At least tree of these four Requirements must be reached. That is checked
	 * by verifying that the requirement status are equal to {@link SUFFICIENT}
	 * or {@link EXCEPTIONAL}
	 */
	private List<Requirement> secondaryReqs;

	public TotalRequirementsChecker(PasswordDTO dto) {
		lengthReq = dto.getLengthReq();
		secondaryReqs = Arrays.asList(dto.getUppercaseReq(), dto.getLowercaseReq(), dto.getNumbersReq(), dto.getSymbolsReq());
	}

	@Override
	public Requirement check(String password) {

		Integer count = new Long(secondaryReqs.stream()
				.filter(req -> req.isSufficientOrExceptional()).count())
						.intValue();
		Integer bonus = 0;

		if (lengthReq.isSufficientOrExceptional()) {
			count += 1;
			bonus = count >= MIN_COUNT ? count * BONUS_MULTIPLIER : 0;
		}

		return new Requirement(count, bonus, getStatus(count));
	}

	@Override
	protected boolean isExceptional(Integer count) {
		return isSufficient(count) && count > MIN_COUNT;
	}

	@Override
	protected boolean isSufficient(Integer count) {
		return lengthReq.isSufficientOrExceptional() && count >= MIN_COUNT;
	}

	@Override
	protected boolean isWarning(Integer count) {
		return false;
	}

}
