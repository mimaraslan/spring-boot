package com.mimaraslan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mimaraslan.model.Student;
import com.mimaraslan.repository.DynamoDbRepository;

@RestController
@RequestMapping("/dynamodb")
public class DynamoDbController {

	@Autowired
	private DynamoDbRepository repository;
	
	@PostMapping
	public Student insertIntoDynamoDB(@RequestBody Student student) {
		System.out.println("Successfully inserted into DynamoDB table");
		return repository.insertIntoDynamoDB(student);
	}

	@GetMapping
	public ResponseEntity<Student> getOneStudentDetails(@RequestParam String studentId, @RequestParam String lastName) {
		Student student = repository.getOneStudentDetails(studentId, lastName);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@PutMapping
	public Student updateStudentDetails(@RequestBody Student student) {
		return repository.updateStudentDetails(student);
	}

	@DeleteMapping(value = "/{studentId}/{lastName}")
	public String deleteStudentDetails(@PathVariable("studentId") String studentId,
			@PathVariable("lastName") String lastName) {
		Student student = new Student();
		student.setStudentId(studentId);
		student.setLastName(lastName);
		repository.deleteStudentDetails(student);
		return "Successfully deleted from DynamoDB table";

	}
}