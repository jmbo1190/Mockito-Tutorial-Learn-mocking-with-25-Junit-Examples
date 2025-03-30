package com.in28minutes.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.in28minutes.data.api.TodoService;


public class TodoBusinessImplMockTest {
    // What is mocking?
    // Mocking is a way to create fake objects that simulate the behavior of a real objects.
    // They can be programmed to return different values based on the input parameters.
    // Unlike stubs, which provide fixed responses to method calls, mocks can be dynamically created from code at runtime.
    // They allow to test the behavior of a class without relying on its dependencies.
    //Mocks offer more functionality than stubs. They can be used to verify interactions between objects,
    // such as method calls and argument values

    // In this example, we are using Mockito to create a mock of the TodoService interface.
    // The mock object will return a predefined list of todos when the retrieveTodos method is called.
    // This allows us to test the TodoBusinessImpl class in isolation,
    // without relying on the actual implementation of the TodoService interface.
    // The TodoService interface is a dependency of the TodoBusinessImpl class.
    // We are using dependency injection to pass the mock object to the TodoBusinessImpl class.

    @Test
    public void usingMockito() {
        // Create a mock of the TodoService interface
        TodoService todoServiceMock = mock(TodoService.class);

        // Define the behavior of the mock when retrieveTodos is called
        // with the argument "Ranga"
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        Mockito.when(todoServiceMock.retrieveTodos("Ranga")).thenReturn(allTodos);

        // Create an instance of the TodoBusinessImpl class, passing the mock as a dependency
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // Call the method to be tested
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");

        // Verify that the filteredTodos list has 2 items
        assertEquals(2, filteredTodos.size());

        // Verify that the filteredTodos list contains the expected items
        assertEquals("Learn Spring MVC", filteredTodos.get(0));
        assertEquals("Learn Spring", filteredTodos.get(1));
        // Verify that the filteredTodos list does not contain the unexpected item
        assertFalse(filteredTodos.contains("Learn to Dance"));

    }
    
}
