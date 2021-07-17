package com.mimaraslan.repository;

import com.mimaraslan.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {

    // All CRUD databases methods

}
