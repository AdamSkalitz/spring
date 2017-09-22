package com.victoria.demos.dataservice;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.victoria.demos.model.Author;
public class AuthorRowMapper implements RowMapper <Author> {

	@Override
	public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
		Author author = new Author();
		author.setBusinessEntityID(rs.getInt("BusinessEntityID"));
		author.setForeName(rs.getString("FirstName"));
		author.setSurName(rs.getString("LastName"));
		author.setGender(rs.getString("Gender"));
		author.setHireDate(rs.getDate("HireDate"));
		return author;
	}

}
