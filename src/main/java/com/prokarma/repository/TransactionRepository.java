package com.prokarma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prokarma.model.CustomerTransaction;

public interface TransactionRepository extends JpaRepository<CustomerTransaction, Integer>{
	public List<CustomerTransaction> getByCustomerId(Integer customerId);
	
	public List<CustomerTransaction> getByVin(String vin);
	
	public CustomerTransaction getById(Integer id);

}
