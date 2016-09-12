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
public class ConsecLowercaseCheckerTest {

	private ConsecLowercaseChecker checker;

	@Before
	public void setup() {
		checker = new ConsecLowercaseChecker();
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
		Requirement req = checker.check("aCDeGBhY%3");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void treeConsecutiveLowercaseTest() {
		Requirement req = checker.check("aagADf4aI");
		assertEquals(2, req.getCount().intValue());
		assertEquals(-4, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void fourAndTwoConsecutiveLowercaseTest() {
		Requirement req = checker.check("AGGaadaFF4Adi");
		assertEquals(4, req.getCount().intValue());
		assertEquals(-8, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

}
