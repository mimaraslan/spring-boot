package com.mimaraslan.service;

import com.mimaraslan.model.Department;
import com.mimaraslan.model.Employee;
import com.mimaraslan.repository.DepartmentRepository;
import com.mimaraslan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        System.out.println("Getting data from DB : " + employees);
        return employees;
    }
/*
    public List<Employee> getEmployeeById(int id) {
        return repository.findById(id);
    }
*/
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }
}
