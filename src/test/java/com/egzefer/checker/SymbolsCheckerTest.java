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
public class SymbolsCheckerTest {

	private SymbolsChecker checker;

	@Before
	public void setup() {
		checker = new SymbolsChecker();
	}

	@Test
	public void emptyPasswordTest() {
		Requirement req = checker.check("");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void noSymbolsTest() {
		Requirement req = checker.check("AGGADFfdzzAF");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void withOneSymbolsTest() {

		Requirement req = checker.check("AGGAdF4@zAF");
		assertEquals(1, req.getCount().intValue());
		assertEquals(6, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void withTwoSymbolsTest() {
		Requirement req = checker.check("AG)AdF4@AF");
		assertEquals(2, req.getCount().intValue());
		assertEquals(12, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}

	@Test
	public void withMoreSymbolsTest() {
		Requirement req = checker.check("AG)AdF4@#AF");
		assertEquals(3, req.getCount().intValue());
		assertEquals(18, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}

	@Test
	public void onlySymbolsTest() {
		Requirement req = checker.check("!@#$%¨&*_+");
		assertEquals(10, req.getCount().intValue());
		assertEquals(60, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}
}
