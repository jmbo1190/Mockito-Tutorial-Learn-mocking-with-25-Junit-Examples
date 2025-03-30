package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

	@Before
	public void setup() {
		// This method is called before each test
		System.out.println("\nBefore Test");
	}

	@After
	public void teardown() {
		// This method is called after each test
		System.out.println("After Test");
	}

	// AACD => CD ACD => CD CDEF=>CDEF CDAA => CDAA

	StringHelper helper = new StringHelper();
	
	private String input;
	private String expectedOutput;
	
	public StringHelperParameterizedTest(String input, String expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<String[]> testConditions() {
		String expectedOutputs[][] = { 
				{ "AACD", "CD" }, 
				{ "ACD", "CD" } };
		return Arrays.asList(expectedOutputs);
	}

	@Test
	public void testTruncateAInFirst2Positions() {
		System.out.println("  Input: " + input);
		System.out.println("  Expected Output: " + expectedOutput);
		System.out.println("  Actual Output: " + helper.truncateAInFirst2Positions(input));
		System.out.println("Test");
		System.out.println("====================================");
		// This method is called for each test
		assertEquals(expectedOutput, 
				helper.truncateAInFirst2Positions(input));
	}
}
