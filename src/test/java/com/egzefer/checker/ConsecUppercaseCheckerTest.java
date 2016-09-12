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
public class ConsecUppercaseCheckerTest {

	private ConsecUppercaseChecker checker;

	@Before
	public void setup() {
		checker = new ConsecUppercaseChecker();
	}

	@Test
	public void emptyPasswordTest() {
		Requirement req = checker.check("");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void noRepetitionTest() {
		Requirement req = checker.check("acDegBhy%3");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void treeConsecutiveUppercaseTest() {
		Requirement req = checker.check("AGGadF4Ai");
		assertEquals(2, req.getCount().intValue());
		assertEquals(-4, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void fourAndTwoConsecutiveUppercaseTest() {
		Requirement req = checker.check("AGGGadFF4Ai");
		assertEquals(4, req.getCount().intValue());
		assertEquals(-8, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

}
