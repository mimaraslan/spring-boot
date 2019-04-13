package com.mimaraslan.service;

import org.springframework.stereotype.Service;

@Service("aService")
public class AService implements MessageService{

	public void sendMsg(String message) {
		System.out.println(message);
	}

}