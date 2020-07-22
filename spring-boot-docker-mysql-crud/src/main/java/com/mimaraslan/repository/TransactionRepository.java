package com.mimaraslan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mimaraslan.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}