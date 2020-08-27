package com.mimaraslan.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mimaraslan.model.User;
import com.mimaraslan.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	@GetMapping("/users/v1/{id}")
	public User retrieveUserV1(@PathVariable int id) {
		return userService.findOne(id);
	}


	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		User user = userService.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("ID: "+ id);
		}
		return user;
	}

	
	@PostMapping("/users/v1")
	public User createUserV1(@RequestBody User user) {
		User savedUser = userService.save(user);
		return savedUser;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userService.save(user);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}
