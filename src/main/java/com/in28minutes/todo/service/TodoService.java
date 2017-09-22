package com.in28minutes.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.victoria.demos.model.Todo;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "An Author", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "Another Author", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "An Author", "Learn Hibernate", new Date(), false));
		todos.add(new Todo(4, "An Author", "Learn ASP.Net MVC", new Date(), false));
		todos.add(new Todo(5, "An Author", "Learn C#", new Date(), false));
		todos.add(new Todo(6, "An Author", "Learn to boogie", new Date(), true));
	}

	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equalsIgnoreCase(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}
	public List<Todo> retrieveAllTodos() {
		
		return todos;
	}

	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}

	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public Todo retrieveTodo(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}
}