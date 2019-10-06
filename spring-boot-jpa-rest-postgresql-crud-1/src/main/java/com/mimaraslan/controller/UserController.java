package com.mimaraslan.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.mimaraslan.exception.ResourceNotFoundException;
import com.mimaraslan.model.User;
import com.mimaraslan.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	
	// http://localhost:8080/api/v1/users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// http://localhost:8080/api/v1/users/1
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(
			@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
		return ResponseEntity.ok().body(user);
	}

	/* 
	 http://localhost:8080/api/v1/users
	
	{
    	"firstName": "Mimar",
    	"lastName": "Aslan",
    	"emailId": "mimar.aslan@gmail.com",
    	"createdBy": "2019-10-06T18:24:56.314+0000",
    	"updatedby": "2019-10-06T18:24:56.314+0000"
	}
	*/
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	
	/* 
	 http://localhost:8080/api/v1/users/1
	
	{
    	"firstName": "Murat",
    	"lastName": "Aylin",
    	"emailId": "mimaraslan@hotmail.com"
	}
	*/
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(
			@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
		        .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
		
		user.setEmailId(userDetails.getEmailId());
		user.setLastName(userDetails.getLastName());
		user.setFirstName(userDetails.getFirstName());
		user.setUpdatedAt(new Date());
		final User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	// http://localhost:8080/api/v1/users/1
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(
			@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
		        .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
