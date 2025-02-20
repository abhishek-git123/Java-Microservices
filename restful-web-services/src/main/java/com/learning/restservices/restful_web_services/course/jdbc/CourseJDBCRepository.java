package com.learning.restservices.restful_web_services.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.restservices.restful_web_services.course.Course;

//Spring JDBC

@Repository
public class CourseJDBCRepository {
	@Autowired
	private JdbcTemplate springJdbcTemplate; 
	
	private static String INSERT_QUERY =
			"""
			insert into course(id,name,author) values(?,?,?)			
			""";
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
}
