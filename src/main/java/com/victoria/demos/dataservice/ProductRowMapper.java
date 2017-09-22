package com.victoria.demos.dataservice;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.victoria.demos.model.Product;

public class ProductRowMapper implements RowMapper<Product>{

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProductID(rs.getInt("ProductID"));
		product.setName(rs.getString("Name"));
		product.setColour(rs.getString("Color"));
		product.setListPrice(rs.getDouble("ListPrice"));
		return product;
	}
	
}
