package com.ramRanjan.FitnessApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.CustomerDao;
import com.ramRanjan.FitnessApp.dao.CustomerLibraryDao;
import com.ramRanjan.FitnessApp.dao.CustomerSurveyDao;
import com.ramRanjan.FitnessApp.dto.CustomerDto;
import com.ramRanjan.FitnessApp.dto.DtoConfig;
import com.ramRanjan.FitnessApp.entity.Customer;
import com.ramRanjan.FitnessApp.entity.CustomerLibrary;
import com.ramRanjan.FitnessApp.entity.CustomerSurvey;
import com.ramRanjan.FitnessApp.exception.CustomerEmailAlreadyExistingException;
import com.ramRanjan.FitnessApp.exception.CustomerNotFoundByEmailException;
import com.ramRanjan.FitnessApp.exception.CustomerNotSignedUpException;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	@Autowired
	private CustomerDto dto;
	@Autowired
	private CustomerSurveyDao surveyDao;
	@Autowired
	private CustomerLibraryDao libraryDao;

	@Autowired
	private DtoConfig dtoConfig;

	public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(Customer customer) {

		Customer existingCustomer = dao.findByCustomerEmail(customer.getCustomerEmail());

		if (existingCustomer != null)
			throw new CustomerEmailAlreadyExistingException("Customer Email Already Present");
		else {
			ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
			customer = dao.saveCustomer(customer);
			dto = dtoConfig.getCustomerDtoAttributes(customer);

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

				updatedCustomer
						.setCustomerName(updatedCustomer.getCustomerName() != null ? updatedCustomer.getCustomerName()
								: existingCustomer.getCustomerName());
				updatedCustomer.setCustomerContact(
						updatedCustomer.getCustomerContact() > 0 ? updatedCustomer.getCustomerContact()
								: existingCustomer.getCustomerContact());
				updatedCustomer.setCustomerEmail(
						updatedCustomer.getCustomerEmail() != null ? updatedCustomer.getCustomerEmail()
								: existingCustomer.getCustomerEmail());
				updatedCustomer.setCustomerPassword(
						updatedCustomer.getCustomerPassword() != null ? updatedCustomer.getCustomerPassword()
								: existingCustomer.getCustomerPassword());

				updatedCustomer = dao.updateCustomer(id, updatedCustomer);
				dto = dtoConfig.getCustomerDtoAttributes(updatedCustomer);

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
			dto = dtoConfig.getCustomerDtoAttributes(customer);

			ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Customer has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new IdNotFoundException("Customer Id Not Present");
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomerById(int id) {
		Customer customer = dao.findCustomerById(id);
		if (customer != null) {
			CustomerLibrary customerLibrary = customer.getLibrary();
			CustomerSurvey customerSurvey = customer.getCustomerSurvey();
			customer.setCustomerSurvey(null);
			customer.setLibrary(null);
			libraryDao.deleteCustomerLibraryById(customerLibrary.getLibraryId());
			surveyDao.deleteCustomerSurveyById(customerSurvey.getCustomer_surveyId());

			customer = dao.deleteCustomerById(id);

			dto = dtoConfig.getCustomerDtoAttributes(customer);

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
			dto = dtoConfig.getCustomerDtoAttributes(customer);

			ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Customer has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new CustomerNotFoundByEmailException("Customer Email Not Present");
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> findByCustomerEmailAndCustomerPassword(String customerEmail,
			String customerPassword) {

		Customer customer = dao.findByCustomerEmailAndCustomerPassword(customerEmail, customerPassword);
		if (customer != null) {
			dto = dtoConfig.getCustomerDtoAttributes(customer);

			ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Customer has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new CustomerNotSignedUpException("Customer Email Not Present");
	}

	public ResponseEntity<ResponseStructure<List<CustomerDto>>> getAllCustomers() {
		List<CustomerDto> dtoList = new ArrayList<CustomerDto>();

		List<Customer> list = dao.getAllCustomers();
		for (Customer customer : list) {
			CustomerDto dto = new CustomerDto();
			dto = dtoConfig.getCustomerDtoAttributes(customer);

			dtoList.add(dto);
		}
		ResponseStructure<List<CustomerDto>> structure = new ResponseStructure<List<CustomerDto>>();

		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("All Customers data is displayed");
		structure.setData(dtoList);
		return new ResponseEntity<ResponseStructure<List<CustomerDto>>>(structure, HttpStatus.FOUND);

	}

}
