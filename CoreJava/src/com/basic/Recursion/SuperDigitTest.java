package com.basic.Recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuperDigitTest {

	@Test
	public void testSuperDigit() {
		int actual = SuperDigit.superDigit("123", 3);
		int expected = 9;
		assertEquals(actual, expected);
	}

}
