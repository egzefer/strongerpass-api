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
public class UppercaseCheckerTest {

	private UppercaseChecker checker;

	@Before
	public void setup() {
		checker = new UppercaseChecker();
	}

	@Test
	public void emptyPasswordTest() {
		Requirement req = checker.check("");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void noUppercaseTest() {
		Requirement req = checker.check("aggadf432@#23af");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void withOneUppercaseTest() {
		Requirement req = checker.check("aggaDf432@#23af");
		assertEquals(1, req.getCount().intValue());
		assertEquals(28, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void withTwoUppercaseTest() {
		Requirement req = checker.check("agTgAf432@#23a");
		assertEquals(2, req.getCount().intValue());
		assertEquals(24, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}

	@Test
	public void withMoreUppercaseTest() {
		Requirement req = checker.check("agTgADf432@#23aF");
		assertEquals(4, req.getCount().intValue());
		assertEquals(24, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}

	@Test
	public void onlyUppercaseTest() {
		Requirement req = checker.check("ASLKDJSALKHJ");
		assertEquals(12, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}
}
