package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student {

    @GetMapping("/message")
    public String getMessage(){
        return "Dockerize Java app using Google Jib!";
    }

}
