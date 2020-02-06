package com.prokarma.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokarma.constants.ApiConstants;
import com.prokarma.model.Customer;
import com.prokarma.model.CustomerTransaction;
import com.prokarma.model.Vehicle;
import com.prokarma.repository.CustomerRepository;
import com.prokarma.repository.TransactionRepository;
import com.prokarma.repository.VehicleRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	public List<CustomerTransaction> getAll(){
		return transactionRepository.findAll();
	}
	
	public List<CustomerTransaction> getByCustomerId(Integer customerId){
		return transactionRepository.getByCustomerId(customerId);
	}
	
	public CustomerTransaction getById(Integer id) {
		return transactionRepository.getById(id);
	}
	
	public CustomerTransaction createPurchase(Integer customerId, Integer vehicleId) {
		Customer customer = customerRepository.getById(customerId);
		Vehicle vehicle = vehicleRepository.getById(vehicleId);
		if (customer == null || vehicle == null 
				|| customer.getId() == null || customer.getId() == 0 
				|| vehicle.getId() == null || vehicle.getOwnerId() != 0)
			return null;
		CustomerTransaction transaction = new CustomerTransaction();
		transaction.setVehicleId(vehicle.getVin());
		transaction.setCustomerId(customer.getId());
		transaction.setAmtPaid(vehicle.getPrice());
		transaction.setTransactionType(ApiConstants.PURCHASE);
		transaction.setTransactionDate(new Date());
		vehicle.setOwnerId(customer.getId());
		vehicleRepository.save(vehicle);
		transactionRepository.save(transaction);
		return transaction;
	}
	
	public CustomerTransaction createTrade(Integer customerId, Integer tradeId, Integer purchaseId) {
		Customer customer = customerRepository.getById(customerId);
		Vehicle trade = vehicleRepository.getById(tradeId);
		Vehicle purchase = vehicleRepository.getById(purchaseId);
		if (customer == null || trade == null || purchase == null 
				|| customer.getId() == null || customer.getId() == 0 
				|| trade.getId() == null || purchase.getId() == null
				|| trade.getOwnerId() != customer.getId() || purchase.getOwnerId() != 0)
			return null;
		CustomerTransaction transaction = new CustomerTransaction();
		transaction.setVehicleId(purchase.getVin());
		transaction.setCustomerId(customer.getId());
		transaction.setAmtPaid(purchase.getPrice() - (trade.getPrice() * .5));
		transaction.setTransactionType(ApiConstants.TRADE);
		transaction.setTransactionDate(new Date());
		purchase.setOwnerId(customer.getId());
		trade.setOwnerId(0);
		vehicleRepository.save(trade);
		vehicleRepository.save(purchase);
		transactionRepository.save(transaction);
		return transaction;
	}
	
	public CustomerTransaction createService(Integer customerId, Integer vehicleId, String serviceType) {
		Customer customer = customerRepository.getById(customerId);
		Vehicle vehicle = vehicleRepository.getById(vehicleId);
		if (customer == null || vehicle == null || customer.getId() == null 
				|| customer.getId() == 0 || vehicle.getId() == null 
				|| vehicle.getOwnerId() != customer.getId())
			return null;
		CustomerTransaction transaction = new CustomerTransaction();
		transaction.setVehicleId(vehicle.getVin());
		transaction.setCustomerId(customer.getId());
		Double price = ApiConstants.SERVICE_TYPE.get(serviceType);
		if (price == null)
			return null;
		transaction.setAmtPaid(price);
		transaction.setTransactionType(ApiConstants.SERVICE);
		transaction.setTransactionDate(new Date());
		vehicle.setOwnerId(customer.getId());
		transactionRepository.save(transaction);
		return transaction;
	}
	
}
