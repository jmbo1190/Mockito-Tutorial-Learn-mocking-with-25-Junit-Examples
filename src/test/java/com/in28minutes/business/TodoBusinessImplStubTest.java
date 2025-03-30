package com.in28minutes.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.stub.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		// Create an instance of the TodoService stub implementation
		// of the TodoService interface
		// which returns a fixed list of todos with 3 items
		// when the retrieveTodos method is called
		TodoService todoService = new TodoServiceStub();

		// Create an instance of the TodoBusinessImpl (SUT) passing it the TodoService stub instance (dependency injection)
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

		// Call the TodoBusinessImpl (SUT) instance method using the TodoService stub instance
		// to avoid making real calls to the external TodoService
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");

		// Verify the result have been filtered to only 2 items
		assertEquals(2, todos.size());
		// Verify the result contains the expected items
		assertEquals("Learn Spring MVC", todos.get(0));
		assertEquals("Learn Spring", todos.get(1));
		// Verify the result does not contain the unexpected item
		assertFalse(todos.contains("Learn to Dance"));
	}
}
