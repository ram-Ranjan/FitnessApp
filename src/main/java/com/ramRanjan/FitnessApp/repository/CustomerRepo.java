package com.ramRanjan.FitnessApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramRanjan.FitnessApp.entity.Customer;

public interface CustomerRepo  extends JpaRepository<Customer, Integer>{

	public Customer findByCustomerEmail(String customerEmail);
	
	
	public Customer findByCustomerEmailAndCustomerPassword(String customerEmail,String customerPassword);
}
