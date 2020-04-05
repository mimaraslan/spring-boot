package com.mimaraslan.repository;

import com.mimaraslan.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByNameContaining(String name);
}