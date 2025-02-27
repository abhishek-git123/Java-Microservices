package com.learning.restservices.restful_web_services.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.restservices.restful_web_services.user.User;

public interface UserRespository extends JpaRepository<User, Integer>{

}
