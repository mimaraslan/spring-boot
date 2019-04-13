package com.mimaraslan.service;

public class BService implements SelectService{

	public void sendMsg(String message) {
		System.out.println("Service B : " + message);
	}

}