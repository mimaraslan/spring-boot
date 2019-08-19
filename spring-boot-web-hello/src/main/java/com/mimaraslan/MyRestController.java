package com.mimaraslan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	// http://localhost:8080
	@RequestMapping(value = "/")
	public String greeting() {
		return "Hello Spring Boot";
	}
	
	// http://localhost:8080/page2
	@RequestMapping("/page2")
	public String getPage2() {
		return "Hello my page2";
	}

}