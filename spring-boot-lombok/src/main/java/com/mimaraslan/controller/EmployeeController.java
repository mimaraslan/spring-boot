package com.mimaraslan.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mimaraslan.model.Employee;

import lombok.Lombok;

@Controller
public class EmployeeController {

	@GetMapping("/")
	public String viewEmployee(Map<String, Object> model) {
		
//		Employee employee = new EmployeeBuilder()
//                .name("Mimar Aslan")
//                .address("Turkey")
//                .age("38")
//                .build();
//
//System.out.println(lombokModel);  
//		model.put("message", this.message);
		return "index";
	}
	

}
