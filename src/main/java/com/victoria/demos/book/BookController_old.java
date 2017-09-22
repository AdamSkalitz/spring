//package com.victoria.demos.book;
//
//import java.util.Date;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import com.in28minutes.todo.service.TodoService;
//import com.victoria.demos.model.Book;
//import com.victoria.demos.model.Todo;
//
//@Controller
//@SessionAttributes("user")
//public class BookController_old {
//
//	@Autowired
//	private BookService service;
//
//	@RequestMapping(value = "/list-books", method = RequestMethod.GET)
//	public String showBooks(ModelMap model) {
//		String user = (String) model.get("user");
//		model.addAttribute("books", service.retrieveBooks(user));
//		//model.addAttribute("name", "An Author");
//		return "list-books";
//	}
//	
////	@RequestMapping(value = "/add-book", method = RequestMethod.GET)
////	public String showBookPage() {
////		return "book";
////	}
//
//	@RequestMapping(value = "/add-book", method = RequestMethod.GET)
//	public String showBookPage(ModelMap model) {
//		model.addAttribute("book", new Book());
//		return "book";
//	}
//	
//	
////	@RequestMapping(value = "/add-book", method = RequestMethod.POST)
////	public String addBook(ModelMap model, @RequestParam String title, @RequestParam String desc, @RequestParam float price) {
////		service.addBook(title,(String) model.get("user"), desc, price);
////		model.clear();// to prevent request parameter "user" to be passed
////		return "redirect:/list-books";
////	}
//	
//	@RequestMapping(value = "/add-book", method = RequestMethod.POST)
//	public String addBook(ModelMap model, @Valid Book book, BindingResult result) {
//
//		if (result.hasErrors())
//			return "book";
//
//		service.addBook(book.getTitle(),(String) model.get("user"), book.getDescription(), book.getPrice());
//		
//		model.clear();// to prevent request parameter "user" to be passed
//		return "redirect:/list-books";
//	}
//	
//	@RequestMapping(value = "/delete-book", method = RequestMethod.GET)
//	public String deleteBook(@RequestParam int id) {
//		service.deleteBook(id);
//
//		return "redirect:/list-books";
//	}
//	
//	//update functionality
//	
//	@RequestMapping(value = "/update-book", method = RequestMethod.GET)
//	public String showUpdateBookPage(ModelMap model, @RequestParam int id) {
//		model.addAttribute("book", service.retrieveBookByID(id));
//		return "book";
//	}
//
//	@RequestMapping(value = "/update-book", method = RequestMethod.POST)
//	public String updateBook(ModelMap model, @Valid Book book, BindingResult result) {
//		if (result.hasErrors())
//			return "book";
//
//		book.setAuthor("An Author"); //TODO:Remove Hardcoding Later
//		service.updateBook(book);
//
//		model.clear();// to prevent request parameter "user" to be passed
//		return "redirect:/list-books";
//	}
//
//}