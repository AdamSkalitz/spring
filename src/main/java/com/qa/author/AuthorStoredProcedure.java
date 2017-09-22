package com.qa.author;
import java.sql.Types;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.victoria.demos.model.Author;


public class AuthorStoredProcedure extends StoredProcedure {
	private static final String SPROC_NAME = "addAuthor";
	public AuthorStoredProcedure(DataSource datasource){
		super( datasource, SPROC_NAME );
		declareParameter(new SqlParameter("id", Types.INTEGER));
		declareParameter( new SqlOutParameter( "name", Types.VARCHAR ) );
		compile();
	}
	public Object execute(Author author){
		Map<String,Object> results = super.execute(author); return results.get("name");
		
		}
	}

	
}
