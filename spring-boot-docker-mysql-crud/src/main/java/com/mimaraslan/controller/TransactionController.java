package com.mimaraslan.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mimaraslan.exceptions.ResourceNotFoundException;
import com.mimaraslan.model.Transaction;
import com.mimaraslan.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	// http://localhost:8089
    @GetMapping
    public String testDemo(){
        return "LOLO 8089 Docker App Running....!";
    }
    
	@PostMapping("/create")
	public Long createTransaction(@RequestBody Transaction transaction) {
		transactionService.saveTransaction(transaction);
		return transaction.getTransactionId();
	}

	@GetMapping("/viewAll")
	public Iterable<Transaction> viewAllTransactions() {
		return transactionService.getTransactionHistory();
	}

	@GetMapping("/view/{id}")
	public Transaction viewTransactionById(@PathVariable("id") Long id) throws ResourceNotFoundException {
		Optional<Transaction> transaction = transactionService.getTransaction(id);
		if (transaction.isPresent()) {
			return transaction.get();
		}

		throw new ResourceNotFoundException("Invalid transaction reference provided");
	}
	
	
	// http://localhost:8080/view/1
	@PutMapping("/view/{id}")
	public ResponseEntity<Transaction> updateUser(
			@PathVariable(value = "id") Long transactionId,
			@Valid @RequestBody Transaction transactionDetail) throws ResourceNotFoundException {
		Transaction transaction = transactionService.getTransaction(transactionId).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + transactionId));
		transaction.setFromAccount(transactionDetail.getFromAccount());
		transaction.setToAccount(transactionDetail.getToAccount());
		transaction.setAmount(transactionDetail.getAmount());
		final Transaction updatedUser = transactionService.saveTransaction(transaction);
		return ResponseEntity.ok(updatedUser);
	}

	// http://localhost:8080/view/1
	@DeleteMapping("/view/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long transactionId) throws ResourceNotFoundException {
		Transaction transaction = transactionService.getTransaction(transactionId).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + transactionId));
		transactionService.deleteTransaction(transaction);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}
	
	
}
