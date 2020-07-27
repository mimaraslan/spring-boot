package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mimar Aslan
 */
@RestController
@RequestMapping("/api/v1")
public class StudentController {

	// http://localhost:8085/api/v1/message
	@GetMapping("/message")
	public String getMessage() {
		return "Welcome to Spring Boot with Docker App Running!";
	}
}