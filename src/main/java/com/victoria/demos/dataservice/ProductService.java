package com.victoria.demos.dataservice;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.victoria.demos.model.Product;

public class ProductService implements IProductService {

	private JdbcTemplate jdbcTemplate = null;

	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	@Override
	public Product getProductByID(int id) {
		String sql = "SELECT * FROM Production.Product where ProductID=?";
		Product product = getJdbcTemplate().queryForObject(sql, new Object[] { id }, new ProductRowMapper());
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		RowMapper<Product> mapper = new ProductRowMapper();
		String sql = "select * from Production.Product";
		return getJdbcTemplate().query(sql, mapper);
	}

	@Override
	public List<Product> getProductsByColour(String colour) {
		String sql = "SELECT * FROM Production.Product where color=?";
		return getJdbcTemplate().query(sql, new Object[] { colour }, new ProductRowMapper());

	}

	@Override
	public void addProduct(Product product) {

		String sql = "insert into Production.Product (NAME, COLOR, LISPRICE) values(?,?,?)";
		Object[] params = new Object[] { product.getName(), product.getColour(), product.getListPrice() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.DOUBLE };
		jdbcTemplate.update(sql, params, types);

	}

	@Override
	public void deleteProduct(int id) {

		String sql = "delete from Production.Product where ProductID=?";
		Object[] params = new Object[] { id };
		jdbcTemplate.update(sql, params);
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "update Production.Product set Name = ?, Color = ?, ListPrice = ? where ProductID=?";
		Object[] params = new Object[] { product.getName(), product.getColour(), product.getListPrice(),
				product.getProductID() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.DOUBLE, Types.INTEGER };
		jdbcTemplate.update(sql, params, types);

	}

}
