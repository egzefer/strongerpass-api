package com.egzefer.checker;

import static com.egzefer.Status.FAILURE;
import static com.egzefer.Status.SUFFICIENT;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.egzefer.Requirement;

@RunWith(SpringRunner.class)
public class LengthCheckerTest {

	private LengthChecker checker;

	@Before
	public void setup() {
		checker = new LengthChecker();
	}

	@Test
	public void emptyPasswordTest() {
		Requirement req = checker.check("");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void oneCharacterTest() {
		Requirement req = checker.check("a");
		assertEquals(1, req.getCount().intValue());
		assertEquals(4, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void sevenCharactersTest() {
		Requirement req = checker.check("abjdljg");
		assertEquals(7, req.getCount().intValue());
		assertEquals(28, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void eightCharactersTest() {
		Requirement req = checker.check("abjdljgv");
		assertEquals(8, req.getCount().intValue());
		assertEquals(32, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

}
