package com.victoria.demos.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.victoria.demos.model.Book;

@Service
public class BookService {
	private static List<Book> books = new ArrayList<Book>();
	private static int bookCount = 4;

	static {
		books.add(new Book(1, "Book 1", "An Author", "A really cool book",4.99f));
		books.add(new Book(2, "Book 2", "Another Author", "A really awesome book",6.95f));
		books.add(new Book(3, "Book 3", "Author Author", "A really boring book",8.99f));
		books.add(new Book(4, "Book 4", "An Author", "A really long book but worth the read",7.85f));
		books.add(new Book(5, "Book 5", "An Author", "Another really long book",6.99f));
	}

	public List<Book> retrieveBooks(String author) {
		List<Book> filteredBooks = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getAuthor().equalsIgnoreCase(author))
				filteredBooks.add(book);
		}
		return filteredBooks;
	}

	public void addBook(String title, String author, String desc, float price) {
		books.add(new Book(++bookCount, title, author, desc, price));
	}

	public void deleteBook(int id) {
		Iterator<Book> iterator = books.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public Book retrieveBookByID(int id) {
		for (Book book : books) {
			if (book.getId() == id)
				return book;
		}
		return null;
	}
	public List<Book> retrieveAllBooks() {
		
		return books;
	}

	public void updateBook(Book book) {
		books.remove(book);
		books.add(book);
	}
}