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
public class NumbersCheckerTest {

	private NumbersChecker checker;

	@Before
	public void setup() {
		checker = new NumbersChecker();
	}

	@Test
	public void emptyPasswordTest() {
		Requirement req = checker.check("");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void noNumbersTest() {
		Requirement req = checker.check("AGGADFfd@#AF");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void withOneNumbersTest() {
		Requirement req = checker.check("AGGAdF4@#AF");
		assertEquals(1, req.getCount().intValue());
		assertEquals(4, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void withTwoNumbersTest() {
		Requirement req = checker.check("GtgADf2@#2Af");
		assertEquals(2, req.getCount().intValue());
		assertEquals(8, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}

	@Test
	public void withMoreNumbersTest() {
		Requirement req = checker.check("3GtgADf432@#23Af");
		assertEquals(6, req.getCount().intValue());
		assertEquals(24, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}

	@Test
	public void onlyNumbersTest() {
		Requirement req = checker.check("34575439856");
		assertEquals(11, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}
}
