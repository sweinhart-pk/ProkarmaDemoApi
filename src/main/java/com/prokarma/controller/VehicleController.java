package com.prokarma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.model.Customer;
import com.prokarma.model.Vehicle;
import com.prokarma.service.VehicleService;

@RestController
@RequestMapping("/dealer")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
    @PostMapping(value = "/vehicle")
    public ResponseEntity<Void> createVehicle() {
    	vehicleService.createVehicle();
        return new ResponseEntity(HttpStatus.OK);
    }
	
}
