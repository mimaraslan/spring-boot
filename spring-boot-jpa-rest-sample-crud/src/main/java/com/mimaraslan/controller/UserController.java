package com.mimaraslan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mimaraslan.model.User;
import com.mimaraslan.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	
	// http://localhost:8080/api/v1/users
	@GetMapping("/users")
	public List<User> getUserAll() {
		return userRepository.findAll();
	}

	// http://localhost:8080/api/v1/users/1
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserFindById(@PathVariable(value = "id") Long id) {
		User user = userRepository.findById(id).get();
		return ResponseEntity.ok().body(user);
	}

	
	/* 
	 http://localhost:8080/api/v1/users
	
	{
		"firstName": "Mimar",
		"lastName": "Aslan"
	}
	*/
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	
	/* 
	 http://localhost:8080/api/v1/users/1
	
	{
		"firstName": "Murat",
		"lastName": "Aylin"
	}
	*/
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUserById(@RequestBody User updateUser, @PathVariable Long id) {
		User user = userRepository.findById(id).get();
		user.setFirstName(updateUser.getFirstName());
		user.setLastName(updateUser.getLastName());
		userRepository.save(user);
		return ResponseEntity.ok().body(user);
	}

	// http://localhost:8080/api/v1/users/1
	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable(value = "id") Long id) {
		User user = userRepository.findById(id).get();
		userRepository.delete(user);
		return "OK";

	}

}
