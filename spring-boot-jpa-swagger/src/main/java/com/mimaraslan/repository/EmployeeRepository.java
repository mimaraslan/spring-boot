package com.mimaraslan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mimaraslan.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}