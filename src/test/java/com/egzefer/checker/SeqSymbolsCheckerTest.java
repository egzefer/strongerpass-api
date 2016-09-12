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
public class SeqSymbolsCheckerTest {

	private SeqSymbolsChecker checker;

	@Before
	public void setup() {
		checker = new SeqSymbolsChecker();
	}

	@Test
	public void emptyPasswordTest() {
		Requirement req = checker.check("");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void oneSymbolTest() {
		Requirement req = checker.check("!");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void treeSequentialNumbersTest() {
		Requirement req = checker.check(")%\"#$!%*");
		assertEquals(1, req.getCount().intValue());
		assertEquals(-3, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void fiveSequentialSymbolsTest() {
		Requirement req = checker.check("!\"#$%");
		assertEquals(3, req.getCount().intValue());
		assertEquals(-9, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void fiveAndFourSequentialSameSymbolsTest() {
		Requirement req = checker.check("\"!\"#$%*&\"#$%");
		assertEquals(3, req.getCount().intValue());
		assertEquals(-9, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

}
