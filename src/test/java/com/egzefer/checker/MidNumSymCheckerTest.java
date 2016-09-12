package com.egzefer.checker;

import static com.egzefer.Status.EXCEPTIONAL;
import static com.egzefer.Status.FAILURE;
import static com.egzefer.Status.SUFFICIENT;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.egzefer.Requirement;

@RunWith(SpringRunner.class)
public class MidNumSymCheckerTest {

	private MidNumSymChecker checker;

	@Before
	public void setup() {
		checker = new MidNumSymChecker();
	}

	@Test
	public void emptyPasswordTest() {
		Requirement req = checker.check("");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void oneDigitTest() {
		Requirement req = checker.check("1");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void twoDigitsTest() {
		Requirement req = checker.check("12");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void treeDigitsTest() {
		Requirement req = checker.check("123");
		assertEquals(1, req.getCount().intValue());
		assertEquals(2, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void fourDigitsOrSymbolsTest() {
		Requirement req = checker.check("1@3*");
		assertEquals(2, req.getCount().intValue());
		assertEquals(4, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}

	@Test
	public void digitsAndLetersTest() {
		Requirement req = checker.check("abj4&dljg4");
		assertEquals(2, req.getCount().intValue());
		assertEquals(4, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}

	@Test
	public void lettersOnlyTest() {
		Requirement req = checker.check("abjdljgv");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

}
