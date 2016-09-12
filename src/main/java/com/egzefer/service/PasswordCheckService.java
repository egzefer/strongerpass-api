package com.egzefer.service;

import java.lang.reflect.Field;

import org.springframework.stereotype.Service;

import com.egzefer.Requirement;
import com.egzefer.checker.ConsecLowercaseChecker;
import com.egzefer.checker.ConsecNumbersChecker;
import com.egzefer.checker.ConsecUppercaseChecker;
import com.egzefer.checker.LengthChecker;
import com.egzefer.checker.LettersOnlyChecker;
import com.egzefer.checker.LowercaseChecker;
import com.egzefer.checker.MidNumSymChecker;
import com.egzefer.checker.NumbersChecker;
import com.egzefer.checker.NumbersOnlyChecker;
import com.egzefer.checker.RepeatCharsChecker;
import com.egzefer.checker.SeqLettersChecker;
import com.egzefer.checker.SeqNumbersChecker;
import com.egzefer.checker.SeqSymbolsChecker;
import com.egzefer.checker.SymbolsChecker;
import com.egzefer.checker.TotalRequirementsChecker;
import com.egzefer.checker.UppercaseChecker;
import com.egzefer.dto.PasswordDTO;

@Service
public class PasswordCheckService {

	public PasswordDTO check(String password) {

		PasswordDTO dto = new PasswordDTO();

		dto.setPassword(password);
		dto.setLengthReq(new LengthChecker().check(password));
		dto.setUppercaseReq(new UppercaseChecker().check(password));
		dto.setLowercaseReq(new LowercaseChecker().check(password));
		dto.setNumbersReq(new NumbersChecker().check(password));
		dto.setSymbolsReq(new SymbolsChecker().check(password));
		dto.setMidNumSymReq(new MidNumSymChecker().check(password));
		dto.setTotalRequirementsReq(new TotalRequirementsChecker(dto).check(null));

		dto.setLettersOnlyReq(new LettersOnlyChecker().check(password));
		dto.setNumbersOnlyReq(new NumbersOnlyChecker().check(password));
		dto.setRepeatCharsReq(new RepeatCharsChecker().check(password));
		dto.setConsecUppercaseReq(new ConsecUppercaseChecker().check(password));
		dto.setConsecLowercaseReq(new ConsecLowercaseChecker().check(password));
		dto.setConsecNumbersReq(new ConsecNumbersChecker().check(password));
		dto.setSeqLettersReq(new SeqLettersChecker().check(password));
		dto.setSeqNumbersReq(new SeqNumbersChecker().check(password));
		dto.setSeqSymbolsReq(new SeqSymbolsChecker().check(password));

		dto.setScore(calculateScore(dto));

		return dto;
	}

	private Integer calculateScore(PasswordDTO dto) {

		Integer score = 0;
		for (Field field : dto.getClass().getDeclaredFields()) {

			if (field.getType().equals(Requirement.class)) {
				try {
					field.setAccessible(true);
					score += ((Requirement) field.get(dto)).getBonus();
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// do nothing
				}
			}
		}

		return score;
	}

}
