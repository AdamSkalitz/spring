package com.in28minutes.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.todo.service.TodoService;
import com.victoria.demos.model.Todo;

@Controller
//@SessionAttributes("user") //Not used with Spring Security
public class TodoController {

	@Autowired
	private TodoService service;

//	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
//	public String showTodos(ModelMap model) {
//		model.addAttribute("todos", service.retrieveTodos("in28Minutes"));
//		return "list-todos";
//	}
	
	//
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		//uses Spring security
		String user = getLoggedInUserName();
		
		model.addAttribute("todos", service.retrieveTodos(user));
		return "list-todos";
	}
	
//	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
//	public String showTodoPage() {
//		return "todo";
//	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo());
		return "todo";
	}
	
//	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
//	public String addTodo(ModelMap model, @RequestParam String desc) {
//		service.addTodo((String) model.get("user"), desc, new Date(), false);
//		model.clear();// to prevent request parameter "name" to be passed
//		return "redirect:/list-todos";
//	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors())
			return "todo";

		//retrieve logged in user
		service.addTodo(getLoggedInUserName(), todo.getDesc(),	todo.getTargetDate(), false);
		
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);

		return "redirect:/list-todos";
	}
	
	//update functionality
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		model.addAttribute("todo", service.retrieveTodo(id));
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors())
			return "todo";

		//removed hard-coding
		todo.setUser(getLoggedInUserName()); 
		service.updateTodo(todo);
		//a fake error to test the Exception Controller
		//throw new NullPointerException("Fake error for testing error handling");

		model.clear();// to prevent request parameter "user" to be passed
		return "redirect:/list-todos";
	}

	//used for enabling editing of the date property using a jQuery widget
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	//used for Spring Security
//	private String getLoggedInUserName(ModelMap model) {
//		return (String) model.get("user");
//	}
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
}