package com.prokarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prokarma.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

}
