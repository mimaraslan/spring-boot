package com.turkeyjug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MainApplication {

	@GetMapping("/message")
	public String getMessage() {
		return "Welcome to Spring Boot with Docker";
	}

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}