package com.prokarma.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prokarma.model.CustomerTransaction;
import com.prokarma.service.TransactionService;

@RestController
@RequestMapping("/dealer/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping
	public ResponseEntity<CustomerTransaction> getAllTransactions(){
		List<CustomerTransaction> transactions = transactionService.getAll();
		return new ResponseEntity(transactions, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CustomerTransaction> getTransactionById(@Valid @PathVariable(value = "id", required = true) @NotBlank Integer id){
		CustomerTransaction transaction = transactionService.getById(id);
		return new ResponseEntity(transaction, HttpStatus.OK);
	}
	
	@GetMapping(value = "/customer/{id}")
	public ResponseEntity<CustomerTransaction> getTransactionsByCustomerId(@Valid @PathVariable(value = "id", required = true) @NotBlank Integer customerId){
		List<CustomerTransaction> transactions = transactionService.getByCustomerId(customerId);
		return new ResponseEntity(transactions, HttpStatus.OK);
	}
	
	@PostMapping(value = "/purchase")
	public ResponseEntity<CustomerTransaction> createPurchase(@Valid @RequestParam(value = "customerId", required = true) @NotBlank Integer customerId,
			@Valid @RequestParam(value = "purchaseId", required = true) @NotBlank Integer purchaseId){
		CustomerTransaction transaction = transactionService.createPurchase(customerId, purchaseId);
		if (transaction == null)
			return new ResponseEntity("Error during purchase", HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity(transaction, HttpStatus.OK);
	}
	
	@PostMapping(value = "/trade")
	public ResponseEntity<CustomerTransaction> createTrade(@Valid @RequestParam(value = "customerId", required = true) @NotBlank Integer customerId,
			@Valid @RequestParam(value = "tradeId", required = true) @NotBlank Integer tradeId,
			@Valid @RequestParam(value = "purchaseId", required = true) @NotBlank Integer purchaseId){
		CustomerTransaction transaction = transactionService.createTrade(customerId, tradeId, purchaseId);
		if (transaction == null)
			return new ResponseEntity("Error during trade", HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity(transaction, HttpStatus.OK);
	}
	
	@PostMapping(value = "/service")
	public ResponseEntity<CustomerTransaction> createService(@Valid @RequestParam(value = "customerId", required = true) @NotBlank Integer customerId,
			@Valid @RequestParam(value = "vehicleId", required = true) @NotBlank Integer vehicleId,
			@Valid @RequestParam(value = "serviceType", required = true) @NotBlank String serviceType){
		CustomerTransaction transaction = transactionService.createService(customerId, vehicleId, serviceType);
		if (transaction == null)
			return new ResponseEntity("Error during service", HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity(transaction, HttpStatus.OK);
	}
}
