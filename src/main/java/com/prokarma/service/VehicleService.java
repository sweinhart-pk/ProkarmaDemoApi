package com.prokarma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prokarma.model.Vehicle;
import com.prokarma.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;
	
	public List<Vehicle> findByOwnerId(Integer ownerId){
		return vehicleRepository.findByOwnerId(ownerId);
	}
	
	public List<Vehicle> getAll(){
		return vehicleRepository.findAll();
	}
	
	public Vehicle getById(Integer id) {
		return vehicleRepository.getById(id);
	}
	
	public void deleteById(Integer id) {
		vehicleRepository.deleteById(id);
	}
	
	public Vehicle createVehicle(Vehicle vehicle) {
		try {
			vehicleRepository.save(vehicle);
			return vehicleRepository.save(vehicle);
		} catch (Exception e) {
			return null;
		}

	}
}
