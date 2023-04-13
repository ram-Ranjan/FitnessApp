package com.ramRanjan.FitnessApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.CustomerDao;
import com.ramRanjan.FitnessApp.dto.CustomerDto;
import com.ramRanjan.FitnessApp.entity.Customer;
import com.ramRanjan.FitnessApp.exception.CustomerEmailAlreadyExistingException;
import com.ramRanjan.FitnessApp.exception.CustomerNotFoundByEmailException;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	@Autowired
	private CustomerDto dto;

	public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(Customer customer) {

		Customer existingCustomer = dao.findByCustomerEmail(customer.getCustomerEmail());

		if (existingCustomer != null)
			throw new CustomerEmailAlreadyExistingException("Customer Email Already Present");
		else {
			ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
			customer = dao.saveCustomer(customer);
			dto.setCustomerId(customer.getCustomerId());
			dto.setCustomerName(customer.getCustomerName());
			dto.setCustomerContact(customer.getCustomerContact());
			dto.setCustomerEmail(customer.getCustomerEmail());

			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Customer has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.CREATED);
		}

	}

	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(int id, Customer updatedCustomer) {

		Customer existingCustomer = dao.findCustomerById(id);

		if (existingCustomer != null) {

			Customer customerWithEmail = dao.findByCustomerEmail(updatedCustomer.getCustomerEmail());
			if (customerWithEmail != null)
				throw new CustomerEmailAlreadyExistingException("Customer Email Already Present");
			else {

				updatedCustomer = dao.updateCustomer(id, updatedCustomer);
				dto.setCustomerId(updatedCustomer.getCustomerId());
				dto.setCustomerName(updatedCustomer.getCustomerName());
				dto.setCustomerContact(updatedCustomer.getCustomerContact());
				dto.setCustomerEmail(updatedCustomer.getCustomerEmail());

				ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("Customer has been Updated");
				responseStructure.setData(dto);
				return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.OK);
			}
		} else
			throw new IdNotFoundException("Customer Id Not Present");
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> findCustomerbyId(int id) {

		Customer customer = dao.findCustomerById(id);
		if (customer != null) {
			dto.setCustomerId(customer.getCustomerId());
			dto.setCustomerName(customer.getCustomerName());
			dto.setCustomerContact(customer.getCustomerContact());

			dto.setCustomerEmail(customer.getCustomerEmail());

			ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Customer has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new IdNotFoundException("Customer Id Not Present");
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomerById(int id) {
		Customer customer = dao.deleteCustomerById(id);
		if (customer != null) {
			dto.setCustomerId(customer.getCustomerId());
			dto.setCustomerName(customer.getCustomerName());
			dto.setCustomerContact(customer.getCustomerContact());
			dto.setCustomerEmail(customer.getCustomerEmail());

			ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Customer has been Deleted");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.OK);
		} else
			throw new IdNotFoundException("Customer Id Not Present");

	}

	public ResponseEntity<ResponseStructure<CustomerDto>> findByCustomerEmail(String customerEmail) {

		Customer customer = dao.findByCustomerEmail(customerEmail);
		if (customer != null) {
			dto.setCustomerId(customer.getCustomerId());
			dto.setCustomerName(customer.getCustomerName());
			dto.setCustomerContact(customer.getCustomerContact());
			dto.setCustomerEmail(customer.getCustomerEmail());

			ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Customer has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new CustomerNotFoundByEmailException("Customer Email Not Present");
	}

	public ResponseEntity<ResponseStructure<List<CustomerDto>>> getAllCustomers() {
		List<CustomerDto> dtoList = new ArrayList<CustomerDto>();

		List<Customer> list = dao.getAllCustomers();
		for (Customer c : list) {
			CustomerDto dto = new CustomerDto();
			dto.setCustomerId(c.getCustomerId());
			dto.setCustomerName(c.getCustomerName());
			dto.setCustomerContact(c.getCustomerContact());
			dto.setCustomerEmail(c.getCustomerEmail());
			dtoList.add(dto);
		}
		ResponseStructure<List<CustomerDto>> structure = new ResponseStructure<List<CustomerDto>>();

		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("All Customers data is displayed");
		structure.setData(dtoList);
		return new ResponseEntity<ResponseStructure<List<CustomerDto>>>(structure, HttpStatus.FOUND);

	}

}
