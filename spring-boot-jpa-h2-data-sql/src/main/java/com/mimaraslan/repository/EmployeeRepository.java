package com.mimaraslan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mimaraslan.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}