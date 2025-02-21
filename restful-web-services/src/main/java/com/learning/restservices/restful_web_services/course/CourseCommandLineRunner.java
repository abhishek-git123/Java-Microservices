package com.learning.restservices.restful_web_services.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.restservices.restful_web_services.course.Course;
import com.learning.restservices.restful_web_services.course.jpa.CourseJpaRepository;
import com.learning.restservices.restful_web_services.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	//@Autowired
	//private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS JPA","Brad Pitt"));
		repository.save(new Course(2, "Learn Azure JPA","Jack Sparrow"));
		repository.save(new Course(3, "Learn Dev Ops JPA","Donald Duck"));
		
		
		repository. deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		
	}

}
