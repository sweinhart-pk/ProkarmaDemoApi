package com.prokarma.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokarma.constants.ApiConstants;
import com.prokarma.model.Customer;
import com.prokarma.model.CustomerTransaction;
import com.prokarma.model.Vehicle;
import com.prokarma.repository.TransactionRepository;
import com.prokarma.repository.VehicleRepository;

@Service
public class CustomerTransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	public List<CustomerTransaction> getAll(){
		return transactionRepository.findAll();
	}
	
	public List<CustomerTransaction> getByCustomerId(Integer customerId){
		return transactionRepository.getByCustomerId(customerId);
	}
	
	public CustomerTransaction getById(Integer id) {
		return transactionRepository.getOne(id);
	}
	/*
	public void createPurchase(Customer customer, Vehicle vehicle) {
		CustomerTransaction transaction = new CustomerTransaction();
		transaction.setVehicleId(vehicle.getVin());
		transaction.setCustomer_id(customer.getId());
		transaction.setAmtPaid(vehicle.getPrice());
		transaction.setTransaction_type(ApiConstants.PURCHASE);
		transaction.setTransaction_date(new Date());
		vehicle.setOwner_id(customer.getId());
		vehicleRepository.save(vehicle);
		transactionRepository.save(transaction);
	}
	
	public void createTrade(Customer customer, Vehicle trade, Vehicle purchase) {
		CustomerTransaction transaction = new CustomerTransaction();
		transaction.setVehicleId(purchase.getVin());
		transaction.setCustomer_id(customer.getId());
		transaction.setAmtPaid(purchase.getPrice() - (trade.getPrice() * .5));
		transaction.setTransaction_type(ApiConstants.TRADE);
		transaction.setTransaction_date(new Date());
		purchase.setOwner_id(customer.getId());
		trade.setOwner_id(0);
		vehicleRepository.save(trade);
		vehicleRepository.save(purchase);
		transactionRepository.save(transaction);
	}
	
	public boolean createService(Customer customer, Vehicle vehicle, String serviceType) {
		CustomerTransaction transaction = new CustomerTransaction();
		transaction.setVehicleId(vehicle.getVin());
		transaction.setCustomer_id(customer.getId());
		Double price = ApiConstants.SERVICE_TYPE.get(serviceType);
		if (price == null)
			return false;
		transaction.setAmtPaid(price);
		transaction.setTransaction_type(ApiConstants.SERVICE);
		transaction.setTransaction_date(new Date());
		vehicle.setOwner_id(customer.getId());
		transactionRepository.save(transaction);
		return true;
	}
	*/
}
