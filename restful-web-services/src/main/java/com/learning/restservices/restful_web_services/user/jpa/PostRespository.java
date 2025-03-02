package com.learning.restservices.restful_web_services.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.restservices.restful_web_services.user.Post;

public interface PostRespository extends JpaRepository<Post, Integer>{

}
