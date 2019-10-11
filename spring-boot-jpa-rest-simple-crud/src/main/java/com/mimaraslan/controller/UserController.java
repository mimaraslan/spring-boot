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
import com.mimaraslan.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	

	// http://localhost:8080/api/v1/users
	@GetMapping("/users")
	public List<User> getUserAll() {
		return userService.getUserAll();
	}

	
	// http://localhost:8080/api/v1/users/1
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserFindById(@PathVariable("id") Long id) {
	 /* User user = userRepository.findById(id).get();
		return ResponseEntity.ok().body(user);
		*/
		return userService.getUserById(id);
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
		// return userRepository.save(user);
		return userService.insertUser(user);
	}

	
	/* 
	 http://localhost:8080/api/v1/users/1
	
	{
		"firstName": "Murat",
		"lastName": "Aylin"
	}
	*/
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable(value = "id") Long id) {
	  /*User userNewValue = userRepository.findById(id).get();
		userNewValue.setFirstName(updateUser.getFirstName());
		userNewValue.setLastName(updateUser.getLastName());
		userRepository.save(userNewValue);
		return ResponseEntity.ok().body(user);
		*/
		return userService.updateUserById(user, id);
	}

	
	// http://localhost:8080/api/v1/users/1
	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable("id") Long id) {
	  /*User user = userRepository.findById(id).get();
		userRepository.delete(user);
		return "OK";
		*/
		return userService.deleteUserById(id);
	}

}