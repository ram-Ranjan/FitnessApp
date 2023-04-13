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
import com.ramRanjan.FitnessApp.dto.CustomerLibraryDto;
import com.ramRanjan.FitnessApp.entity.CustomerLibrary;
import com.ramRanjan.FitnessApp.service.CustomerLibraryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/library")
public class CustomerLibraryController 
{
	@Autowired
	private CustomerLibraryService service;
	
	@ApiOperation(value = "Save  Customer Library", notes = "API is used to Save Customer Library ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
			@ApiResponse(code = 400, message = "Id not found for the given Customer Library ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> saveCustomerLibrary(@Valid @RequestBody CustomerLibrary library,int customerId)
	{
		
		return service.saveCustomerLibrary(library,customerId);
	}
	
	
	@ApiOperation(value = "Update  Customer Library", notes = "API is used to Update Customer Library ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given Customer Library ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> updateCustomerLibrary(@Valid @RequestParam int customerLibraryId,@RequestBody CustomerLibrary library)
	{
		
		return service.updateCustomerLibrary(customerLibraryId, library);
	}
	
	
	@ApiOperation(value = "Update  Customer Library with Workout", notes = "API is used to Update Customer Library ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given Customer Library ID  or Workout Id") })
	@PutMapping("addWorkout")
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> addLibraryWorkout(@Valid   @RequestParam int workoutId ,@RequestParam int customerLibraryId)
	{
		
		return service.addLibraryWorkout(workoutId, customerLibraryId);
	}
	
	
	@ApiOperation(value = "Find  Customer Library based on id", notes = "API is used to find Customer Library ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 400, message = "Id not found for the given Customer Library ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> findCustomerLibraryById(@RequestParam int customerLibraryId)
	{
		
		return service.findCustomerLibrarybyId(customerLibraryId);
	}
	
	
	@ApiOperation(value = "Delete  Customer Library", notes = "API is used to Delete Customer Library ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Deleted"),
			@ApiResponse(code = 400, message = "Id not found for the given Customer Library ID") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> deleteCustomerLibraryById(@RequestParam int customerLibraryId)
	{
		
		return service.deleteCustomerLibraryById(customerLibraryId);
	}
	
	
	
	
}
	

