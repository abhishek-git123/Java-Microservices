package com.learning.restservices.restful_web_services.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	///autowired
	UserDaoService userDaoService;
	
	public UserResource(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping(path="/users/{userId}")
	public User retrieveAllUsers(@PathVariable int userId){
		return userDaoService.findParticularUser(userId);
	}
}
