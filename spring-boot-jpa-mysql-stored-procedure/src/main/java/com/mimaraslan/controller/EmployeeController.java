package com.mimaraslan.controller;

import com.mimaraslan.model.Employee;
import com.mimaraslan.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/api/employee")
public class EmployeeController {

	@Autowired
    EmployeeRepository employeeRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to fetch all employees from the db.
	 * @return
	 */
	// http://localhost:8002/api/employee/all
	@GetMapping(value= "/all")
	public Iterable<Employee> getAll() {
		logger.debug("Get all employees.");
		return employeeRepository.getAllEmployees();
	}

	/**
	 * Method to fetch employees on the basis of department.
	 * @param department
	 * @return
	 */
	// http://localhost:8002/api/employee/department/Technology
	@GetMapping(value= "/department/{department}")
	public Iterable<Employee> getEmployeesByDepartment(@PathVariable(name= "department") String department) {
		logger.debug("Getting count for department= {}.", department);
		return employeeRepository.getEmployeesByDepartment(department);
	}

	/**
	 * Method to fetch employees count on the basis of position.
	 * @param position
	 * @return
	 */
	// http://localhost:8002/api/employee/count/Lead
	@GetMapping(value= "/count/{position}")
	public Integer getEmployeeCountByPosition(@PathVariable(name= "position") String position) {
		logger.debug("Getting count for employee positions= {}.", position);
		return employeeRepository.getEmployeesCountByPosition(position);
	}
}