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
import com.prokarma.model.Customer;
import com.prokarma.service.CustomerService;

@RestController
@RequestMapping("/dealer/customer")
public class CustomerController {
    
    @Autowired
    CustomerService customerService;
    
    @GetMapping
    public ResponseEntity<Customer> getAllCustomers() {
    	List<Customer> customers = customerService.getAll();
        return new ResponseEntity(customers, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@Valid @PathVariable(value = "id", required = true) @NotBlank Integer id) {
    	Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity(customer, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody(required = true) Customer customer) {
    	customerService.createCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCustomer(@Valid @PathVariable(value = "id", required = true) @NotBlank Integer id){
    	boolean result = customerService.deleteCustomer(id);
    	if (result)
    		return new ResponseEntity<>("Customer Deleted", HttpStatus.OK);
    	else
    		return new ResponseEntity<>("Error Deleting Customer", HttpStatus.BAD_REQUEST);
    }
}
