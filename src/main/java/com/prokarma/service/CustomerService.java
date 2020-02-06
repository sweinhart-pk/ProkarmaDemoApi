package com.prokarma.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokarma.model.Customer;
import com.prokarma.model.Vehicle;
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
		List<Customer> customers = customerRepository.findAll();
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles = vehicleRepository.findAll();
		for (Customer customer : customers) {
			for (Vehicle vehicle : vehicles) {
				if (vehicle.getOwnerId() == customer.getId()) {
					customer.addVehicle(vehicle);
				}
			}
		}
		
		return customers;
	}
/*
	public Customer getCustomerById(Integer id) {
		Customer customer = customerRepository.getOne(id);
		List<Vehicle> vehicles = vehicleRepository.findAll();
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getOwner_id() == customer.getId()) {
				customer.addVehicle(vehicle);
			}
		}
		return customer;
	}
	
	public Customer getCustomerByName(String name) {
		Customer customer = customerRepository.getCustomerByName(name);
		List<Vehicle> vehicles = vehicleRepository.findAll();
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getOwner_id() == customer.getId()) {
				customer.addVehicle(vehicle);
			}
		}
		return customer;
	}
	
	public void deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
		List<Vehicle> vehicles = vehicleRepository.findAll();
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getOwner_id() == id) {
				vehicles.remove(vehicle);
			}
		}
		vehicleRepository.saveAll(vehicles);
	}
	*/
}
