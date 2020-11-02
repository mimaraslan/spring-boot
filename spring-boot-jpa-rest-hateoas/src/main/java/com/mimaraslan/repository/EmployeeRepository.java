package com.mimaraslan.resoruce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mimaraslan.model.Employee;

@Repository
public interface EmployeeResource extends JpaRepository<Employee, Long> {

}
