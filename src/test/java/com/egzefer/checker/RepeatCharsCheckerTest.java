package com.egzefer.checker;

import static com.egzefer.Status.SUFFICIENT;
import static com.egzefer.Status.WARNING;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.egzefer.Requirement;

@Ignore // See RepeatCharsChecker
@RunWith(SpringRunner.class)
public class RepeatCharsCheckerTest {

	private RepeatCharsChecker checker;

	@Before
	public void setup() {
		checker = new RepeatCharsChecker();
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
	public void twoLetterRepetitionsTest() {
		Requirement req = checker.check("AGGadF4Ai");
		assertEquals(5, req.getCount().intValue());
		assertEquals(-10, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void numberAndSymbolRepetitionTest() {
		Requirement req = checker.check("1acDe1g%Bhy%33");
		assertEquals(6, req.getCount().intValue());
		assertEquals(-12, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

}
