package com.learning.restservices.restful_web_services.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.restservices.restful_web_services.course.Course;

@Component
public class CourseJPACommandLineRunner implements CommandLineRunner{
	@Autowired
	private CourseJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		/*repository.insert(new Course(1, "Learn AWS JPA","Brad Pitt"));
		repository.insert(new Course(2, "Learn Azure JPA","Jack Sparrow"));
		repository.insert(new Course(3, "Learn Dev Ops JPA","Donald Duck"));
		
		
		repository.deleteById(1);
		
		System.out.println(repository.findById(2));
		System.out.println(repository.findById(3));
		*/
	}

}
