package com.mimaraslan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootSchedulerJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchedulerJobApplication.class, args);
	}
}