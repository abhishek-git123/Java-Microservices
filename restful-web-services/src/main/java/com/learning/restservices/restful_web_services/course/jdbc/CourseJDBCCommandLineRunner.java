package com.learning.restservices.restful_web_services.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.restservices.restful_web_services.course.Course;

@Component
public class CourseJDBCCommandLineRunner implements CommandLineRunner{
	@Autowired
	private CourseJDBCRepository repository;
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1, "Learn AWS","Brad Pitt"));
		repository.insert(new Course(2, "Learn Azure","Jack Sparrow"));
		repository.insert(new Course(3, "Learn Dev Ops","Donald Duck"));
		
		
		repository.delete(1);
		
		System.out.println(repository.findById(2));
		System.out.println(repository.findById(3));
	}

}
