package com.ramRanjan.FitnessApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dto.CustomerDto;
import com.ramRanjan.FitnessApp.entity.Customer;
import com.ramRanjan.FitnessApp.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerControlller 
{
	@Autowired
	private CustomerService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(@RequestBody Customer customer)
	{
		
		return service.saveCustomer(customer);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(@RequestParam int id,@RequestBody Customer customer)
	{
		
		return service.updateCustomer(id, customer);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> findCustomerById(@RequestParam int id)
	{
		
		return service.findCustomerbyId(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomer(@RequestParam int id)
	{
		
		return service.deleteCustomerById(id);
	}
	
	
	
	
}
	

