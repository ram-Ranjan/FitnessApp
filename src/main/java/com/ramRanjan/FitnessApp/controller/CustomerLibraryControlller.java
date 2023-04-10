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
import com.ramRanjan.FitnessApp.dto.CustomerLibraryDto;
import com.ramRanjan.FitnessApp.entity.CustomerLibrary;
import com.ramRanjan.FitnessApp.service.CustomerLibraryService;

@RestController
@RequestMapping("/library")
public class CustomerLibraryControlller 
{
	@Autowired
	private CustomerLibraryService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> saveCustomerLibrary(@RequestBody CustomerLibrary library)
	{
		
		return service.saveCustomerLibrary(library);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> updateCustomerLibrary(@RequestParam int id,@RequestBody CustomerLibrary library)
	{
		
		return service.updateCustomerLibrary(id, library);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> findCustomerLibraryById(@RequestParam int id)
	{
		
		return service.findCustomerLibrarybyId(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> deleteCustomerLibraryById(@RequestParam int id)
	{
		
		return service.deleteCustomerLibraryById(id);
	}
	
	
	
	
}
	

