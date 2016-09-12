package com.egzefer.checker;

import static com.egzefer.Status.SUFFICIENT;
import static com.egzefer.Status.WARNING;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.egzefer.Requirement;

@RunWith(SpringRunner.class)
public class SeqLettersCheckerTest {

	private SeqLettersChecker checker;

	@Before
	public void setup() {
		checker = new SeqLettersChecker();
	}

	@Test
	public void emptyPasswordTest() {
		Requirement req = checker.check("");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void oneCharacterTest() {
		Requirement req = checker.check("a");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void treeSequentialCharactersTest() {
		Requirement req = checker.check("acabjdefljg");
		assertEquals(1, req.getCount().intValue());
		assertEquals(-3, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void treeSequentialCharactersMultipleCaseTest() {
		Requirement req = checker.check("aBcabjdfljg");
		assertEquals(1, req.getCount().intValue());
		assertEquals(-3, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void fiveSequentialCharactersTest() {
		Requirement req = checker.check("abjcdefgljgv");
		assertEquals(3, req.getCount().intValue());
		assertEquals(-9, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void fiveAndFourSequentialSameCharactersTest() {
		Requirement req = checker.check("abjcdefgl4ghiJabjcdefgv");
		assertEquals(5, req.getCount().intValue());
		assertEquals(-15, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void fiveAndFourSequentialDifferentCharactersTest() {
		Requirement req = checker.check("abjmnopql4ghiJabjcdefv");
		assertEquals(7, req.getCount().intValue());
		assertEquals(-21, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void overlappingCharactersTest() {
		Requirement req = checker.check("abcdefgefgh");
		assertEquals(6, req.getCount().intValue());
		assertEquals(-18, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

}
