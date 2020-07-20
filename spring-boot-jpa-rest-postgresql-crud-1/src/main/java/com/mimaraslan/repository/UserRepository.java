package com.mimaraslan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mimaraslan.model.Student;

@Repository
public interface UserRepository extends JpaRepository<Student, Long>{
}