package com.learning.restservices.restful_web_services.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.restservices.restful_web_services.user.jpa.UserRespository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	//@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private UserRespository userRepository;
	
	
	public UserJpaResource(UserDaoService userDaoService, UserRespository userRespository) {
		this.userDaoService = userDaoService;
		this.userRepository = userRespository;
	}
	
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		//return userDaoService.findAll();
		return userRepository.findAll();
	}
	//EntityModel
	//WebMVCLinkBuilder
	
	@GetMapping("/jpa/users/{Id}")
	public EntityModel<User> retrieveUsers(@PathVariable int Id){
		Optional<User> user = userRepository.findById(Id);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("Id "+Id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		//create URI of the newly created resource : using location
		//users/4 -> /users/{id} -> users/user.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("jpa/users/{Id}")
	public void deleteUsers(@PathVariable int Id){
		userRepository.deleteById(Id);

	}
}
