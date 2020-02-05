package com.prokarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prokarma.model.CustomerTransaction;

public interface TransactionRepository extends JpaRepository<CustomerTransaction, Integer>{

}
