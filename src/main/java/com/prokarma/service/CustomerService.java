package com.prokarma.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prokarma.model.Customer;
import com.prokarma.repository.CustomerRepository;
import com.prokarma.repository.VehicleRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	VehicleRepository vehicleRepository;
	
	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	public Customer getCustomerById(Integer id) {
		return customerRepository.getById(id);
	}
	
	public Customer getCustomerByName(String name) {
		return customerRepository.getCustomerByName(name);
	}
	
	public Boolean deleteCustomer(Integer id) {
		Customer customer = customerRepository.getById(id);
		if (customer != null && customer.getVehiclesOwned().isEmpty()) {
			customerRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}
