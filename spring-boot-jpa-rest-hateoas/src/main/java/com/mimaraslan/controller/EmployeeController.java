package com.mimaraslan.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mimaraslan.execption.EmployeeNotFoundException;
import com.mimaraslan.model.Employee;
import com.mimaraslan.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/v1/{id}")
	public Employee retrieveEmployeeV1(@PathVariable int id) {
		return employeeService.findOne(id);
	}

	@GetMapping("/employees/{id}")
	public Employee retrieveEmployee(@PathVariable int id) {
		Employee employee = employeeService.findOne(id);
		if (employee == null) {
			throw new EmployeeNotFoundException("ID: " + id);
		}
		return employee;
	}

	@PostMapping("/employees/v1")
	public Employee createEmployeeV1(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.save(employee);
		return savedEmployee;
	}

	@PostMapping("/employees")
	public ResponseEntity<Object> createEmployee(@Valide @RequestBody Employee employee) {
		Employee savedEmployee = employeeService.save(employee);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEmployee.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		Employee employee = employeeService.deleteById(id);
		if (employee == null) {
			throw new EmployeeNotFoundException("ID: " + id);
		}
	}

}
