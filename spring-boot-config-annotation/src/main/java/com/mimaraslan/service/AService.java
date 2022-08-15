package com.mimaraslan.service;

import org.springframework.stereotype.Service;

@Service("aService")
public class AService implements SelectService {

    public void sendMsg(String message) {
        System.out.println("Service A : " + message);
    }

}