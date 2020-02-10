package com.mimaraslan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandLineRunnerOrderApplication {

	public static void main(String[] args) {		
		System.out.println("The service to start.");
		SpringApplication.run(CommandLineRunnerOrderApplication.class, args);
		System.out.println("The service has started.");
		
	}

}
