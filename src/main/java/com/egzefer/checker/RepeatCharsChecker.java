package com.egzefer.checker;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.Map;

import com.egzefer.Requirement;

/**
 * 
 * As www.passwordmeter.com says for this field - Repeat Characters - // Type:
 * Comp: Rates that are too complex to summarize. See source code for details.
 * So it was not possible to determine how the bonus/deduction is being set
 * 
 * @author evandro
 *
 */
public class RepeatCharsChecker extends DeductionChecker {

	private static final int BONUS_MULTIPLIER = 2;

	@Override
	public Requirement check(String password) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		Integer count = 0;
		for (String key : asList(password.toLowerCase().split(""))) {
			if (map.containsKey(key)) {
				count += 1;
			} else {
				map.put(key, 0);
			}
		}
		Integer bonus = count * BONUS_MULTIPLIER * -1;

		return new Requirement(count, bonus, getStatus(count));
	}

}
