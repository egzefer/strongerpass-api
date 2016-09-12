package com.egzefer.checker;

import static com.egzefer.Status.FAILURE;
import static com.egzefer.Status.SUFFICIENT;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.egzefer.Requirement;
import com.egzefer.Status;
import com.egzefer.dto.PasswordDTO;

@RunWith(SpringRunner.class)
public class TotalRequirementsCheckerTest {

	@Test
	public void emptyPasswordTest() {
		Requirement req = getChecker("").check(null);
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void oneCharacterTest() {
		Requirement req = getChecker("a").check(null);
		assertEquals(1, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void sevenCharactersTest() {
		Requirement req = getChecker("abjdljg").check(null);
		assertEquals(1, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void sevenCharactersWithNumberSymbolUppercaseTest() {
		Requirement req = getChecker("ab*dl8G").check(null);
		assertEquals(4, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void eightCharactersTest() {
		Requirement req = getChecker("abjdljgv").check(null);
		assertEquals(2, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void eightCharactersWithNumberSymbolTest() {
		Requirement req = getChecker("ab*djl8g").check(null);
		assertEquals(4, req.getCount().intValue());
		assertEquals(8, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void eightCharactersWithNumberSymbolUppercaseTest() {
		Requirement req = getChecker("ab*djl8G").check(null);
		assertEquals(5, req.getCount().intValue());
		assertEquals(10, req.getBonus().intValue());
		assertEquals(Status.EXCEPTIONAL, req.getStatus());
	}

	private TotalRequirementsChecker getChecker(String password) {
		PasswordDTO dto = new PasswordDTO();

		dto.setLengthReq(new LengthChecker().check(password));
		dto.setUppercaseReq(new UppercaseChecker().check(password));
		dto.setLowercaseReq(new LowercaseChecker().check(password));
		dto.setNumbersReq(new NumbersChecker().check(password));
		dto.setSymbolsReq(new SymbolsChecker().check(password));

		return new TotalRequirementsChecker(dto);
	}

}
