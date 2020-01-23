package com.mimaraslan.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mimaraslan.model.Transaction;
import com.mimaraslan.repository.TransactionRepository;

@Transactional
@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public Iterable<Transaction> getTransactionHistory() {
		return transactionRepository.findAll();
	}

	public Optional<Transaction> getTransaction(Long id) {
		return transactionRepository.findById(id);
	}

	public void deleteTransaction(Transaction transaction) {
		 transactionRepository.delete(transaction);
	}
}
