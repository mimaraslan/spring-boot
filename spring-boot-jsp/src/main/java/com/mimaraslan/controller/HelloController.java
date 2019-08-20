package com.mimaraslan.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "How are you?");
		mav.addObject("currentTime", new Date());
		mav.setViewName("hello");
		return mav;
	}
	
}