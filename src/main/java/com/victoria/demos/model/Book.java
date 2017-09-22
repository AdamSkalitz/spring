package com.victoria.demos.model;

import javax.validation.constraints.Size;

public class Book {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Book [id=%s, title=%s, author=%s, description=%s, price=%s]", id,
				title, author, description, price);
	}
	
	public Book(int id, String title, String author, String desc, float price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = desc;
		this.price = price;
	}
	
	//this is needed for use with command objects
	public Book() {
		super();
	}
	private int id;
	
	@Size(min = 1, message = "Please enter at least 1 character.")
	private String title;
	
	private String author;
	
	@Size(min = 5, max=255, message = "Please enter at least 5 characters and no more than 255 characters.")
	private String description;
	
	private float price;
	
	//needed for comparisons for update functionality
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
