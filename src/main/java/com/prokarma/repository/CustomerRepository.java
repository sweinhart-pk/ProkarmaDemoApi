package com.prokarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prokarma.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
