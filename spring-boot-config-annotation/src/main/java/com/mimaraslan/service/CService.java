package com.mimaraslan.service;

import org.springframework.stereotype.Service;

@Service("cService")
public class CService implements MessageService{

	public void sendMsg(String message) {
		System.out.println(message);
	}

}