package com.victoria.demos.model;

public class Product {

	private int productID;
	private String name;
	private String colour;
	private double listPrice;
	
	
	public Product() {
		this.productID = 0;
		this.name= "Unknown";
		this.colour = "Red";
		this.listPrice = 0.00;
	}
	
	
	public Product(int productID, String name, String colour, double listPrice) {
		super();
		this.productID = productID;
		this.name = name;
		this.colour = colour;
		this.listPrice = listPrice;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getListPrice() {
		return listPrice;
	}
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}
	
	
	
}
