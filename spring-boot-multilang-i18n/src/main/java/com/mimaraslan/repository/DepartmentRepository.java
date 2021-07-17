package com.mimaraslan.repository;

import com.mimaraslan.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository <Department, Long> {

    // All CRUD databases methods

}
