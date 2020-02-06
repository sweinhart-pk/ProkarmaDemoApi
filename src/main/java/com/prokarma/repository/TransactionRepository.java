package com.prokarma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prokarma.model.Customer;
import com.prokarma.model.CustomerTransaction;
import com.prokarma.model.Vehicle;

public interface TransactionRepository extends JpaRepository<CustomerTransaction, Integer>{
	public List<CustomerTransaction> getByCustomerId(Integer customer_id);
	
	public List<CustomerTransaction> getByVehicleId(String vin);

}
