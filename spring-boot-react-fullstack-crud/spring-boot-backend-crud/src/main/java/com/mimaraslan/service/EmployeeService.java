package com.mimaraslan.service;

import com.mimaraslan.model.Employee;
import com.mimaraslan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = repository.findAll();
        System.out.println("Getting data from DB : " + employees);
        return employees;
    }
/*
    public List<Employee> getEmployeeById(int id) {
        return repository.findById(id);
    }
*/
    public void deleteEmployee(Employee employee) {
        repository.delete(employee);
    }
}
