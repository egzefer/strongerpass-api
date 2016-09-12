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
public class LowercaseCheckerTest {

	private LowercaseChecker checker;

	@Before
	public void setup() {
		checker = new LowercaseChecker();
	}

	@Test
	public void emptyPasswordTest() {
		Requirement req = checker.check("");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void noLowercaseTest() {
		Requirement req = checker.check("AGGADF432@#23AF");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(FAILURE, req.getStatus());
	}

	@Test
	public void withOneLowercaseTest() {
		Requirement req = checker.check("AGGAdF432@#23AF");
		assertEquals(1, req.getCount().intValue());
		assertEquals(28, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void withTwoLowercaseTest() {
		Requirement req = checker.check("AGtAD432@#23Af");
		assertEquals(2, req.getCount().intValue());
		assertEquals(24, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}

	@Test
	public void onlyLowercaseTest() {
		Requirement req = checker.check("aslkdjsalkhj");
		assertEquals(12, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(EXCEPTIONAL, req.getStatus());
	}
}
