package com.ramRanjan.FitnessApp.controller;

import java.util.List;

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
import com.ramRanjan.FitnessApp.dto.CustomerDto;
import com.ramRanjan.FitnessApp.entity.Customer;
import com.ramRanjan.FitnessApp.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService service;

	@ApiOperation(value = "Save Customer", notes = "API is used to Save Customer ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
			@ApiResponse(code = 400, message = "Id not found for the given Customer ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(@Valid @RequestBody Customer customer) {

		return service.saveCustomer(customer);
	}

	@ApiOperation(value = "Update Customer Based on Id", notes = "API is used to Update Customer ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
			@ApiResponse(code = 400, message = "Id not found for the given Customer ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(@Valid @RequestParam int customerId,
			@RequestBody Customer customer) {

		return service.updateCustomer(customerId, customer);
	}

	@ApiOperation(value = "find Customer Based on Id", notes = "API is used to Find Customer ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Updated"),
			@ApiResponse(code = 400, message = "Id not found for the given Customer ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> findCustomerById(@RequestParam int customerId) {

		return service.findCustomerbyId(customerId);
	}

	@ApiOperation(value = "Find All Customer", notes = "API is used to find all Customers ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Found"),
			@ApiResponse(code = 400, message = "Id not found for the given Customer ID") })
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<CustomerDto>>> getAllCustomers() {
		return service.getAllCustomers();
	}

	@ApiOperation(value = "Find  Customer Based On Email", notes = "API is used to find  Customer based on id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Found"),
			@ApiResponse(code = 400, message = "Id not found for the given Customer ID") })
	@GetMapping("/email")
	public ResponseEntity<ResponseStructure<CustomerDto>> findCustomerByEmail(
			@Valid @RequestParam String customerEmail) {
		return service.findByCustomerEmail(customerEmail);
	}

	@ApiOperation(value = "Find  Customer Based On Email", notes = "API is used to find  Customer based on id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Found"),
			@ApiResponse(code = 400, message = "Id not found for the given Customer ID") })
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<CustomerDto>> findByCustomerEmailAndCustomerPassword(
			@Valid @RequestParam String customerEmail, @Valid @RequestParam String customerPassword) {
		return service.findByCustomerEmailAndCustomerPassword(customerEmail, customerPassword);
	}

	@ApiOperation(value = " Delete Customer", notes = "API is used to delete Customer ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Deleted"),
			@ApiResponse(code = 400, message = "Id not found for the given Customer ID") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomer(@RequestParam int customerId) {

		return service.deleteCustomerById(customerId);
	}

}
