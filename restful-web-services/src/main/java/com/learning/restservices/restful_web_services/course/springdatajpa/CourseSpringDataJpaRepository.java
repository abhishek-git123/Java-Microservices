package com.learning.restservices.restful_web_services.course.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.restservices.restful_web_services.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{

}
