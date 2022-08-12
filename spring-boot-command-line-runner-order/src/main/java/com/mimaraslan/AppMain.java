package com.mimaraslan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppMain {

	public static void main(String[] args) {		
		System.out.println("The service to start.");
		SpringApplication.run(AppMain.class, args);
		System.out.println("The service has started.");
		
	}

}
