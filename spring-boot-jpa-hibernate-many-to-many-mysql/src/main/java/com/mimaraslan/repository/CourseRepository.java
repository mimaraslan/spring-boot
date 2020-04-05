package com.mimaraslan.repository;

import com.mimaraslan.model.Course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByTitleContaining(String title);

    List<Course> findByFeeLessThan(double fee);
}