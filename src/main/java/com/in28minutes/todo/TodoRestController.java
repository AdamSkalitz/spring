package com.in28minutes.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victoria.demos.model.*;
import com.in28minutes.todo.service.TodoService;


@RestController
public class TodoRestController {
	@Autowired
	private TodoService service;

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/todo/", method = RequestMethod.GET)
	public List<Todo> listAllTodos() {
		List<Todo> users = service.retrieveAllTodos();
		return users;
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public List<Todo> retrieveTodo(@PathVariable("id") int id) {
		Todo singleToDo =  service.retrieveTodo(id);
		List<Todo> todo =new ArrayList<Todo>();
		todo.add(singleToDo);
		return todo;
		
	}
	
//	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
//	public Todo retrieveTodo(@PathVariable("id") int id) {
//		return service.retrieveTodo(id);
//	}
}