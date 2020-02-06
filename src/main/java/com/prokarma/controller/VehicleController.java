package com.prokarma.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prokarma.model.Vehicle;
import com.prokarma.service.VehicleService;

@RestController
@RequestMapping("/dealer/vehicle")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody(required = true) Vehicle vehicle) {
    	vehicle = vehicleService.createVehicle(vehicle);
    	if (vehicle != null)
    		return new ResponseEntity<>(vehicle, HttpStatus.OK);
    	else
    		return new ResponseEntity("Error while creating vehicle", HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping
    public ResponseEntity<Vehicle> getAllVehicles(){
    	List<Vehicle> vehicles = vehicleService.getAll();
    	return new ResponseEntity(vehicles, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@Valid @PathVariable(value = "id", required = true) @NotBlank Integer id){
    	Vehicle vehicle = vehicleService.getById(id);
    	return new ResponseEntity(vehicle, HttpStatus.OK);
    }
	
    @GetMapping(value = "/owner/{id}")
    public ResponseEntity<Vehicle> getVehiclesByOwnerId(@Valid @PathVariable(value = "id", required = true) @NotBlank Integer ownerId){
    	List<Vehicle> vehicles = vehicleService.findByOwnerId(ownerId);
    	return new ResponseEntity(vehicles, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteVehicle(@Valid @PathVariable(value = "id", required = true) @NotBlank Integer id){
    	vehicleService.deleteById(id);
    	return new ResponseEntity("Vehicle Deleted", HttpStatus.OK);
    }
}
