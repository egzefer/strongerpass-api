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
public class NumbersOnlyCheckerTest {

	private NumbersOnlyChecker checker;

	@Before
	public void setup() {
		checker = new NumbersOnlyChecker();
	}

	@Test
	public void emptyPasswordTest() {
		Requirement req = checker.check("");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void numbersOnlyTest() {
		Requirement req = checker.check("5001215578");
		assertEquals(10, req.getCount().intValue());
		assertEquals(-10, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void withLettersTest() {
		Requirement req = checker.check("5001a155Z8");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}
	
	@Test
	public void withSymbolsTest() {
		Requirement req = checker.check("500121557#");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

}
