package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mimar Aslan
 */
@RestController
@RequestMapping
public class DockerDemoController {

	// http://localhost:8085/test
	@GetMapping("test")
	public String testDemo() {
		return "Docker App Running....!";
	}
}