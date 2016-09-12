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
public class LettersOnlyCheckerTest {

	private LettersOnlyChecker checker;

	@Before
	public void setup() {
		checker = new LettersOnlyChecker();
	}

	@Test
	public void emptyPasswordTest() {
		Requirement req = checker.check("");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void lettersOnlyTest() {
		Requirement req = checker.check("AGGaDFfdAF");
		assertEquals(10, req.getCount().intValue());
		assertEquals(-10, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void withNumbersTest() {
		Requirement req = checker.check("AGGAdF4AF");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}
	
	@Test
	public void withSymbolsTest() {
		Requirement req = checker.check("AGGAdF%AF");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

}
