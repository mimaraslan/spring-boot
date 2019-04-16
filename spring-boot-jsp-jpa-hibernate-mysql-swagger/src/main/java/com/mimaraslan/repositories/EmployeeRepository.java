package com.mimaraslan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mimaraslan.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}