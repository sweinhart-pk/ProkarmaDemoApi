package com.prokarma.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.prokarma.repository.CustomerRepository;

public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
}
