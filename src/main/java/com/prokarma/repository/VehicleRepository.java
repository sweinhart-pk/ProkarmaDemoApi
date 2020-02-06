package com.prokarma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prokarma.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	public List<Vehicle> findByOwnerId(Integer ownerId);
	
	public Vehicle getById(Integer id);
}
