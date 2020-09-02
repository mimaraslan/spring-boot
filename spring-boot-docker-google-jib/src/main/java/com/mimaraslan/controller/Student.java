package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class Student {

    @GetMapping("/host")
    public String getHost() {
        StringBuilder message = new StringBuilder("Hello Jib Maven Plugin!");
        try {
            InetAddress ip = InetAddress.getLocalHost();
            message.append(" From host: " + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return message.toString();
    }

    @GetMapping("/message")
    public String getMessage(){
        return "Dockerize Java app using Google Jib!";
    }

}
