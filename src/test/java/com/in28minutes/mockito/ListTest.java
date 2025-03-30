package com.in28minutes.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	public void letsMockListSize() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10);
		assertEquals(10, list.size());
	}

	@Test
	public void letsMockListSizeWithMultipleReturnValues() {
		List list = mock(List.class);
		when(list.size())
			.thenReturn(10)
			.thenReturn(20);
		assertEquals(10, list.size()); // First Call
		assertEquals(20, list.size()); // Second Call
	}

	@Test
	public void letsMockListGet() {
		List<String> list = mock(List.class);
		when(list.get(0)).thenReturn("in28Minutes"); // Configure retun value for get(0)
		assertEquals("in28Minutes", list.get(0));
		assertNull(list.get(1)); // Nice mock behaviour for non-configured values (non-stubbed method): return default (null)
	}

	@Test(expected = RuntimeException.class)  // Expect a RuntimeException
		public void letsMockListGetToThrowException() {
		List list = mock(List.class);
		when(list.get(Mockito.anyInt()))  // Matcher Mockito.anyInt() will match any int value
				// If you are using argument matchers, all arguments
				// have to be provided by matchers.
				// So, you can not use 0 as a value for the first argument
				// and Mockito.anyInt() for the second argument.
				// You can use Mockito.any() for all arguments.
				// Mockito.any() will match any value for the argument
				// and Mockito.anyInt() will match any int value for the arguments
				// and Mockito.anyString() will match any String value for the argument
				// and Mockito.anyList() will match any List value for the argument
				// and Mockito.anyMap() will match any Map value for the argument
				// and Mockito.anySet() will match any Set value for the argument
				// and Mockito.anyDouble() will match any double value for the argument
				// and Mockito.anyFloat() will match any float value for the argument
				// and Mockito.anyLong() will match any long value for the argument
				// and Mockito.anyShort() will match any short value for the argument
				// and Mockito.anyBoolean() will match any boolean value for the argument
				// and Mockito.anyChar() will match any char value for the argument
				// and Mockito.anyByte() will match any byte value for the argument
				.thenThrow(new RuntimeException("Something went wrong"));

		list.get(0);
	}

	@Test
	public void letsMockListGetWithAny() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("in28Minutes");
		// If you are using argument matchers, all arguments
		// have to be provided by matchers.
		assertEquals("in28Minutes", list.get(0));
		assertEquals("in28Minutes", list.get(1));
	}

	@Test
	public void bddAliases_UsingGivenWillReturn() {
		List<String> list = mock(List.class);

		// given (setup)
		given(list.get(Mockito.anyInt()))
			.willReturn("in28Minutes");

		// when (actual invocation)
		String value = list.get(0);

		// then (assertion)
		assertEquals("in28Minutes", value);
		// equivalent to BDD style:
		assertThat(
			list.get(0)            // actual
			,is("in28Minutes")
			);   // matcher 
		// BDD style reads more like English than:
		assertEquals("in28Minutes", list.get(0));
	}
}
