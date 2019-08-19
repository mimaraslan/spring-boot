package com.mimaraslan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	// http://localhost:8080/page1
	@RequestMapping("/page1")
	@ResponseBody
	public String getPage1() {
		return "Hello my page1";
	}
	
}