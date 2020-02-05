package com.prokarma.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.prokarma.repository.VehicleRepository;

public class VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;
}
