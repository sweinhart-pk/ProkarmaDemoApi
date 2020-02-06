package com.prokarma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokarma.constants.ApiConstants;
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
		return vehicleRepository.getOne(id);
	}
	
	public void deleteById(Integer id) {
		vehicleRepository.deleteById(id);
	}
	
	public void createVehicle() {
		Vehicle vehicle = new Vehicle();
		vehicle.setColor("black");
		vehicle.setEngine("3.6L V6");
		vehicle.setHorsepower(280);
		vehicle.setMake("Chevrolet");
		vehicle.setModel("Camaro");
		vehicle.setNumSeats(4);
		vehicle.setOwnerId(0);
		vehicle.setPrice(30000.00);
		vehicle.setSeatsType(ApiConstants.FABRIC);
		vehicle.setVehicleType(ApiConstants.MUSCLE);
		vehicle.setVin("12345abcde");
		vehicle.setYear(1995);
		vehicleRepository.save(vehicle);
	}
}
