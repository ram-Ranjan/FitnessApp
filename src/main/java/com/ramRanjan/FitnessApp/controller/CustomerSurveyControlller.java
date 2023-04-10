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
import com.ramRanjan.FitnessApp.dto.CustomerSurveyDto;
import com.ramRanjan.FitnessApp.entity.CustomerSurvey;
import com.ramRanjan.FitnessApp.service.CustomerSurveyService;

@RestController
@RequestMapping("/controller")
public class CustomerSurveyControlller 
{
	@Autowired
	private CustomerSurveyService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> saveCustomer(@RequestBody CustomerSurvey survey)
	{
		
		return service.saveCustomerSurvey(survey);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> updateCustomerSurvey(@RequestParam int id,@RequestBody CustomerSurvey survey)
	{
		
		return service.updateCustomerSurvey(id, survey);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> findSurveyById(@RequestParam int id)
	{
		
		return service.findCustomerSurveybyId(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> deleteCustomerSurveyByID(@RequestParam int id)
	{
		
		return service.deleteCustomerSurveyById(id);
	}
	
	
	
	
}
	

