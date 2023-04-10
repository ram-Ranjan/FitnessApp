package com.ramRanjan.FitnessApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.CustomerSurveyDao;
import com.ramRanjan.FitnessApp.dto.CustomerSurveyDto;
import com.ramRanjan.FitnessApp.entity.CustomerSurvey;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;

@Service
public class CustomerSurveyService {

	@Autowired
	private CustomerSurveyDao dao;
	@Autowired
	private CustomerSurveyDto dto;

	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> saveCustomerSurvey(CustomerSurvey survey) {
		ResponseStructure<CustomerSurveyDto> responseStructure = new ResponseStructure<>();
		survey = dao.saveCustomerSurvey(survey);
		dto.setCustomer_surveyId(survey.getCustomer_surveyId());
		dto.setCustomer_height(survey.getCustomer_height());
		dto.setCustomer_weight(survey.getCustomer_weight());
		dto.setCusotmer_fitnessLevel(survey.getCusotmer_fitnessLevel());
		dto.setCustomer_goal(survey.getCustomer_goal());

		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Customer survey has been Saved");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<CustomerSurveyDto>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<CustomerSurveyDto>> updateCustomerSurvey(int id, CustomerSurvey survey) {
		survey = dao.updateCustomerSurvey(id, survey);
		if (survey != null) {
			dto.setCustomer_surveyId(survey.getCustomer_surveyId());
			dto.setCustomer_height(survey.getCustomer_height());
			dto.setCustomer_weight(survey.getCustomer_weight());
			dto.setCusotmer_fitnessLevel(survey.getCusotmer_fitnessLevel());
			dto.setCustomer_goal(survey.getCustomer_goal());

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
			dto.setCustomer_surveyId(survey.getCustomer_surveyId());
			dto.setCustomer_height(survey.getCustomer_height());
			dto.setCustomer_weight(survey.getCustomer_weight());
			dto.setCusotmer_fitnessLevel(survey.getCusotmer_fitnessLevel());
			dto.setCustomer_goal(survey.getCustomer_goal());

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
			dto.setCustomer_surveyId(survey.getCustomer_surveyId());
			dto.setCustomer_height(survey.getCustomer_height());
			dto.setCustomer_weight(survey.getCustomer_weight());
			dto.setCusotmer_fitnessLevel(survey.getCusotmer_fitnessLevel());
			dto.setCustomer_goal(survey.getCustomer_goal());
			
			ResponseStructure<CustomerSurveyDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Customer survey has been Deleted");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerSurveyDto>>(responseStructure, HttpStatus.OK);
		} else
			throw new IdNotFoundException("Customer survey Id Not Present");

	}

}
