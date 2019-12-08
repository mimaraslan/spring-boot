package com.mimaraslan.controller;

import com.mimaraslan.model.Subject;
import com.mimaraslan.repository.SubjectRepository;
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
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    // http://localhost:8080/api/v1/subjects
    @GetMapping("/subjects")
    public List<Subject> getSubjectAll() {
        return subjectRepository.findAll();
    }


    // http://localhost:8080/api/v1/subjects/1
    @GetMapping("/subjects/{id}")
    public ResponseEntity<Optional<Subject>> getSubjectFindById(@PathVariable("id") Integer id) {
        Optional<Subject> subject = subjectRepository.findById(id);
		return ResponseEntity.ok().body(subject);

    }
}