package com.ramRanjan.FitnessApp.controller;

import javax.validation.Valid;

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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/survey")
public class CustomerSurveyController 
{
	@Autowired
	private CustomerSurveyService service;
	
	
	@ApiOperation(value = "Save  Customer Survey", notes = "API is used to Save Customer Survey ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
	@ApiResponse(code = 400, message = "Id not found for the given Customer Survey ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> saveCustomer(@Valid @RequestBody CustomerSurvey survey,@Valid @RequestParam int customerId)
	{
		
		return service.saveCustomerSurvey(survey,customerId);
	}
	
	
	@ApiOperation(value = "Update  Customer Survey", notes = "API is used to Save Customer Survey ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
	@ApiResponse(code = 400, message = "Id not found for the given Customer Survey ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> updateCustomerSurvey( @RequestParam int id,@Valid @RequestBody CustomerSurvey survey)
	{
		
		return service.updateCustomerSurvey(id, survey);
	}
	
	
	@ApiOperation(value = "Find  Customer Survey Based on Id", notes = "API is used to Save Customer Survey ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
	@ApiResponse(code = 400, message = "Id not found for the given Customer Survey ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> findSurveyById(@RequestParam int id)
	{
		
		return service.findCustomerSurveybyId(id);
	}
	
	
	@ApiOperation(value = "Delete  Customer Survey", notes = "API is used to Save Customer Survey ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
	@ApiResponse(code = 400, message = "Id not found for the given Customer Survey ID") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> deleteCustomerSurveyByID(@RequestParam int id)
	{
		
		return service.deleteCustomerSurveyById(id);
	}
	
	
	
	
}
	

