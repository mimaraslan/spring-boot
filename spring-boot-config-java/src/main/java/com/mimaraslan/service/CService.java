package com.mimaraslan.service;

public class CService implements SelectService{

	public void sendMsg(String message) {
		System.out.println("Service C : " + message);
	}

}