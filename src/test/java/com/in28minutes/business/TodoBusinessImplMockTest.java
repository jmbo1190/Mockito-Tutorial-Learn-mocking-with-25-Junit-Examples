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
