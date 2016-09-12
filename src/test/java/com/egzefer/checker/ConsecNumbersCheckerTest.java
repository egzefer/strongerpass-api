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
public class ConsecNumbersCheckerTest {

	private ConsecNumbersChecker checker;

	@Before
	public void setup() {
		checker = new ConsecNumbersChecker();
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
		Requirement req = checker.check("aCD2e4GBhY%3");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void treeConsecutiveNumbersTest() {
		Requirement req = checker.check("aagADf214aI");
		assertEquals(2, req.getCount().intValue());
		assertEquals(-4, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void fourAndTwoConsecutiveNumbersTest() {
		Requirement req = checker.check("AGG4432FF48A6di");
		assertEquals(4, req.getCount().intValue());
		assertEquals(-8, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

}
