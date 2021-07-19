package com.mimaraslan;

import com.mimaraslan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBackendCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendCrudApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

}