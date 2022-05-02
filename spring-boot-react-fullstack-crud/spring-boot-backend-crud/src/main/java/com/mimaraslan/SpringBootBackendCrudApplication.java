package com.mimaraslan;

import com.mimaraslan.model.Employee;
import com.mimaraslan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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


// CommandLineRunner
/*
public class SpringBootBackendCrudApplication implements CommandLineRunner {
public class SpringBootBackendCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendCrudApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("FirstName1");
		employee.setLastName("LastName1");
		employee.setEmailId("EmailId1");
		employeeRepository.save(employee);

		Employee employee2 = new Employee();
		employee2.setFirstName("FirstName2");
		employee2.setLastName("LastName2");
		employee2.setEmailId("EmailId2");
		employeeRepository.save(employee2);

	}

}
*/