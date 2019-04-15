package com.mimaraslan.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;

import com.mimaraslan.repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message;

	@RequestMapping({"/","/index"})
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}

	@RequestMapping("/users")
	public String home(Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "users";
	}

}