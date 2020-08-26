package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mimaraslan.model.HelloWorld;

@RestController
public class HelloWorldController {

	@GetMapping("/hi")
	public String hi() {
		return "Hi";
	}

	@GetMapping("/hello")
	public HelloWorld helloWorld() {
		return new HelloWorld("Hello");
	}

	@GetMapping("/hello/{name}")
	public HelloWorld helloWorld(@PathVariable String name) {
		return new HelloWorld("Hello " + name);
	}
}
