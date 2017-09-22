package com.victoria.demos.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victoria.demos.model.*;


@RestController
public class BookRestController {
	@Autowired
	private BookService service;

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/book/", method = RequestMethod.GET)
	public List<Book> listAllBooks() {
		List<Book> books = service.retrieveAllBooks();
		return books;
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public List<Book> retrieveBook(@PathVariable("id") int id) {
		List<Book> book = new ArrayList<Book>();
		Book aBook =  service.retrieveBookByID(id);
		book.add(aBook);
		return book;
	}
}