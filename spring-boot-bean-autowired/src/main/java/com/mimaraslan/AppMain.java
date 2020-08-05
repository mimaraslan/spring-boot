package com.mimaraslan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mimaraslan.config.MyInterface;



@SpringBootApplication
public class AppMain implements CommandLineRunner {

	@Autowired 
	private MyInterface myInterface;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(myInterface.getAppName());
		System.out.println(myInterface.getAppPortNumber());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}

}
