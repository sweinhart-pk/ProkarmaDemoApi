package com.prokarma.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.prokarma.repository.TransactionRepository;

public class CustomerTransactionService {

	@Autowired
	TransactionRepository transactionRepository;
}
