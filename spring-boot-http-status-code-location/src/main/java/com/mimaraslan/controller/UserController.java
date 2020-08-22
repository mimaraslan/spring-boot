package com.mimaraslan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mimaraslan.model.User;
import com.mimaraslan.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public List<User> retrieveAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User retrieveUser(@PathVariable int id){
		return userService.findOne(id);
	}
	
}
