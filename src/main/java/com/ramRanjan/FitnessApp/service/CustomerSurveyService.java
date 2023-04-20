package com.ramRanjan.FitnessApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.CustomerDao;
import com.ramRanjan.FitnessApp.dao.CustomerSurveyDao;
import com.ramRanjan.FitnessApp.dto.CustomerSurveyDto;
import com.ramRanjan.FitnessApp.dto.DtoConfig;
import com.ramRanjan.FitnessApp.entity.Customer;
import com.ramRanjan.FitnessApp.entity.CustomerSurvey;
import com.ramRanjan.FitnessApp.exception.CustomerIdNotFoundException;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;

@Service
public class CustomerSurveyService {

	@Autowired
	private CustomerSurveyDao dao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private CustomerSurveyDto dto;
	@Autowired
	private DtoConfig dtoConfig;

	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> saveCustomerSurvey(CustomerSurvey survey,
			int customerId) {
		ResponseStructure<CustomerSurveyDto> responseStructure = new ResponseStructure<>();

		Customer customer = customerDao.findCustomerById(customerId);

		if (customer != null) {
			customer.setCustomerSurvey(survey);
			survey = dao.saveCustomerSurvey(survey);
			dto = dtoConfig.getCustomerSurveyDtoAttributes(survey);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Customer survey has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerSurveyDto>>(responseStructure, HttpStatus.CREATED);
		} else
			throw new CustomerIdNotFoundException("Customer Id not exist");
	}

	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> updateCustomerSurvey(int id,
			CustomerSurvey updatedSurvey) {
		CustomerSurvey existingSurvey = dao.findCustomerSurveyById(id);
		if (existingSurvey != null) {

			updatedSurvey.setCustomer_fitnessLevel(
					updatedSurvey.getCustomer_fitnessLevel() != null ? updatedSurvey.getCustomer_fitnessLevel()
							: existingSurvey.getCustomer_fitnessLevel());
			updatedSurvey.setCustomer_goal(updatedSurvey.getCustomer_goal() != null ? updatedSurvey.getCustomer_goal()
					: existingSurvey.getCustomer_goal());
			updatedSurvey.setCustomer_heightInMeters(
					updatedSurvey.getCustomer_heightInMeters() > 0 ? updatedSurvey.getCustomer_heightInMeters()
							: existingSurvey.getCustomer_heightInMeters());
			updatedSurvey.setCustomer_weightInKgs(
					updatedSurvey.getCustomer_weightInKgs() > 0 ? updatedSurvey.getCustomer_weightInKgs()
							: existingSurvey.getCustomer_weightInKgs());

			dto = dtoConfig.getCustomerSurveyDtoAttributes(updatedSurvey);
			ResponseStructure<CustomerSurveyDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Customer Survey has been Updated");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerSurveyDto>>(responseStructure, HttpStatus.OK);
		} else
			throw new IdNotFoundException("Customer survey Id Not Present");
	}

	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> findCustomerSurveybyId(int id) {

		CustomerSurvey survey = dao.findCustomerSurveyById(id);

		if (survey != null) {
			dto = dtoConfig.getCustomerSurveyDtoAttributes(survey);

			ResponseStructure<CustomerSurveyDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Customer Survey has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerSurveyDto>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new IdNotFoundException("Customer survey Id Not Present");
	}

	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> deleteCustomerSurveyById(int id) {
		CustomerSurvey survey = dao.deleteCustomerSurveyById(id);
		if (survey != null) {

			dto = dtoConfig.getCustomerSurveyDtoAttributes(survey);

			ResponseStructure<CustomerSurveyDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Customer survey has been Deleted");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerSurveyDto>>(responseStructure, HttpStatus.OK);
		} else
			throw new IdNotFoundException("Customer survey Id Not Present");

	}

}
