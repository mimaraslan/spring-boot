package com.mimaraslan.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mimaraslan.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{
	List<Customer> findByAge(int age);
}