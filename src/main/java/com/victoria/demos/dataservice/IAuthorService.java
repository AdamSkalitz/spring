package com.victoria.demos.dataservice;

import java.sql.Date;
import java.util.List;

import com.victoria.demos.model.Author;

public interface IAuthorService {
	
	public Author getAuthorById(int id);
	
	public List<Author> getAllAuthors();
	
	public List<Author> getAuthorByHireDate(Date hireDate);
	
	public void addAuthor(Author author);

	public void deleteAuthor(int id);

	public void updateAuthor(Author author);

}
