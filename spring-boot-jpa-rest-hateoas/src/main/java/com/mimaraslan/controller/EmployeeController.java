package com.mimaraslan.controller;

import java.net.URI;
import java.util.List;

import com.mimaraslan.repository.EmployeeRepository;
import com.mimaraslan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mimaraslan.execption.EmployeeNotFoundException;
import com.mimaraslan.model.Employee;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees2() {
		return ResponseEntity.ok(employeeService.findAll());
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
