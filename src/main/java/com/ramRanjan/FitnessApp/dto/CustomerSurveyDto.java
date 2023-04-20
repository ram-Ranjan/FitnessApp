package com.ramRanjan.FitnessApp.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CustomerSurveyDto {
	
	private int  customer_surveyId;
	private double customer_heightInMeters;
	private double customer_weightInKgs;
	private String customer_fitnessLevel;
	private String customer_goal;
	private double BMI;
	

}
