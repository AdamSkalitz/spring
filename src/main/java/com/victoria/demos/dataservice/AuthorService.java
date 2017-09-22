package com.victoria.demos.dataservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.Date;

import com.qa.author.AuthorStoredProcedure;
import com.victoria.demos.model.Author;
public class AuthorService implements IAuthorService {

	private JdbcTemplate jdbcTemplate = null;

	String epJoin = "select emp.BusinessEntityID, p.FirstName, p.LastName, emp.Gender, emp.HireDate " +
			 "from HumanResources.Employee as emp inner join Person.Person as p " + 
			"on emp.BusinessEntityID = p.BusinessEntityID";

	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	@Override
	public Author getAuthorById(int id) {
		
		String sql = epJoin + " where emp.BusinessEntityID =?";
		Author author = getJdbcTemplate().queryForObject(sql, new Object[] { id }, new AuthorRowMapper());
		return author;
	}

	@Override
	public List<Author> getAllAuthors() {
		RowMapper<Author> mapper = new AuthorRowMapper();
		String sql = epJoin;
		//String sql = "select * from Person.Person";
		return getJdbcTemplate().query(sql, mapper);
	}

	@Override
	public List<Author> getAuthorByHireDate(Date hireDate) {
		String sql = epJoin + "where emp.HireDate =?";
		List<Author> authorList = getJdbcTemplate().query(sql, new Object[] { hireDate }, new AuthorRowMapper());
		return authorList;
	}

	@Override
	public void addAuthor(Author author) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		AuthorStoredProcedure dao = (AuthorStoredProcedure) ctx.getBean("employeeDao");
		//calling stored procedure using DAO method
		System.out.println("Employee name for id 103 is : " + dao.getEmployeeName(103)); 
		}

		
	}

	@Override
	public void deleteAuthor(int id) {
	}

	@Override
	public void updateAuthor(Author author) {
	}

}
