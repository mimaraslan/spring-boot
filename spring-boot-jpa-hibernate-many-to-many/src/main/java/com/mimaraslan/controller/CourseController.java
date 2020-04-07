package com.mimaraslan.controller;

import com.mimaraslan.model.Course;
import com.mimaraslan.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    // http://localhost:8082/api/v1/courses
    @GetMapping("/courses")
    public List<Course> getCoursesAll() {
        return courseRepository.findAll();
    }


    // http://localhost:8082/api/v1/courses/1
    @GetMapping("/courses/{id}")
    public ResponseEntity<Optional<Course>> getCourseFindById(@PathVariable("id") Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        return ResponseEntity.ok().body(course);
    }
}