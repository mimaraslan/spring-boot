package com.mimaraslan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mimaraslan.model.User;
import com.mimaraslan.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getUserAll() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserFindById(Long id) {
		User user = userRepository.findById(id).get();		
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/users")
	public ResponseEntity<User> updateUserById(User updateUser, Long id) {
		User user = userRepository.findById(id).get();
		user.setFirstName(updateUser.getFirstName());
		user.setLastName(updateUser.getLastName());	
		userRepository.save(user);
		return ResponseEntity.ok().body(user);
	}
	
	public String deleteUserById(Long id) {
		User user = userRepository.findById(id).get();

		if(!user.equals(null)) {
			userRepository.delete(user);
			return "OK";
		}
		return "ID not found.";

	}
	
}
