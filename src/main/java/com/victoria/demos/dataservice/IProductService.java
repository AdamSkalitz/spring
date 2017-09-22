package com.victoria.demos.dataservice;

import java.util.List;

import com.victoria.demos.model.Product;

public interface IProductService {
	
	public Product getProductByID(int id);
	
	public List<Product> getAllProducts();
	
	public List<Product> getProductsByColour(String colour);

	public void addProduct(Product product);

	public void deleteProduct(int id);

	public void updateProduct(Product product);
}
