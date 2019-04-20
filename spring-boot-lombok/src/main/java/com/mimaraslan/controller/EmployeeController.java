package com.mimaraslan.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.mimaraslan.model.Employee;

@Controller
public class EmployeeController {
	
	@GetMapping({"/", "/index"})
	public String viewIndex(Map<String, Object> model) {	
		
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("Mimar");
		employee.setLastName("Aslan");
		employee.setEmail("mimar.aslan@gmail.com");
	
		model.put("message", employee);
		return "index";
	}

}