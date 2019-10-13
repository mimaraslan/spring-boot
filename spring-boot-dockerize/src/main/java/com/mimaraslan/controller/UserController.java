package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	// http://localhost:8080/message
	@GetMapping("/message")
	public String getMessage() {
		return "Welcome to Spring Boot with Docker";
	}
	
}