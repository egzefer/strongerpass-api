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
public class SeqNumbersCheckerTest {

	private SeqNumbersChecker checker;

	@Before
	public void setup() {
		checker = new SeqNumbersChecker();
	}

	@Test
	public void emptyPasswordTest() {
		Requirement req = checker.check("");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void oneNumberTest() {
		Requirement req = checker.check("1");
		assertEquals(0, req.getCount().intValue());
		assertEquals(0, req.getBonus().intValue());
		assertEquals(SUFFICIENT, req.getStatus());
	}

	@Test
	public void treeSequentialNumbersTest() {
		Requirement req = checker.check("05234158");
		assertEquals(1, req.getCount().intValue());
		assertEquals(-3, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void fiveSequentialNumbersTest() {
		Requirement req = checker.check("9449234564432");
		assertEquals(3, req.getCount().intValue());
		assertEquals(-9, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void fiveAndFourSequentialSameNumbersTest() {
		Requirement req = checker.check("212345872345");
		assertEquals(3, req.getCount().intValue());
		assertEquals(-9, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void fiveAndFourSequentialDifferentNumbersTest() {
		Requirement req = checker.check("0123466789");
		assertEquals(5, req.getCount().intValue());
		assertEquals(-15, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

	@Test
	public void overlappingNumbersTest() {
		Requirement req = checker.check("01234345");
		assertEquals(4, req.getCount().intValue());
		assertEquals(-12, req.getBonus().intValue());
		assertEquals(WARNING, req.getStatus());
	}

}
