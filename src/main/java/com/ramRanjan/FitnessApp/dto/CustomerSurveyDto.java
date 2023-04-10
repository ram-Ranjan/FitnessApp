package com.ramRanjan.FitnessApp.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CustomerSurveyDto {
	
	private int  customer_surveyId;
	private int customer_height;
	private int customer_weight;
	private String cusotmer_fitnessLevel;
	private String customer_goal;
	

}
