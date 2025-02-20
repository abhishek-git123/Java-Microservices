package com.learning.restservices.restful_web_services.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//Spring JDBC

@Repository
public class CourseJDBCRepository {
	@Autowired
	private JdbcTemplate springJdbcTemplate; 
	
	private static String INSERT_QUERY =
			"""
			insert into course(id,name,author) values(1,'Java Spring Boot','Donald Trump')
			
			""";
	public void insert() {
		springJdbcTemplate.update(INSERT_QUERY);
	}
}
