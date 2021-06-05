package com.mimaraslan.controller;

import com.mimaraslan.util.Utility;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class Student {

    // http://localhost:8082/student/info/{studentName}
    @GetMapping("/info/{studentName}")
    public boolean getInfo (@PathVariable String studentName){
        System.out.println(studentName);
        return Utility.isNotNull(studentName);
    }
}
