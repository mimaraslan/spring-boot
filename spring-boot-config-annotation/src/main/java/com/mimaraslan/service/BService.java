package com.mimaraslan.service;

import org.springframework.stereotype.Service;

@Service("bService")
public class BService implements SelectService{

	public void sendMsg(String message) {
		System.out.println("Service B : " + message);
	}

}