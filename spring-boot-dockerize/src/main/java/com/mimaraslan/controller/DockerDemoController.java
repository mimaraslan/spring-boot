package com.mimaraslan.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lolo
 */
@RestController
@RequestMapping
public class DockerDemoController {

	// http://localhost:8085/test
    @GetMapping("test")
    public String testDemo(){
        return "LOLO 8085 Docker App Running....!";
    }
}
