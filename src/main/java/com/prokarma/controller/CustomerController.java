package com.prokarma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prokarma.model.Customer;
import com.prokarma.service.CustomerService;

@RestController
@RequestMapping("/dealer")
public class CustomerController {
    private static String version = "1.0";
    
    @Autowired
    CustomerService customerService;
    
    @GetMapping(value = "/customer")
    public ResponseEntity<Customer> getAllCustomers() {
    	List<Customer> customers = customerService.getAll();
        return new ResponseEntity(customers, HttpStatus.OK);
    }
}
