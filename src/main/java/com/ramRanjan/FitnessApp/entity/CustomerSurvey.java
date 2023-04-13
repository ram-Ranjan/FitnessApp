package com.ramRanjan.FitnessApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Entity
@Data
public class CustomerSurvey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  customer_surveyId;
	@Positive
	private double customer_heightInMeters;
	@Positive
	private double customer_weightInKgs;
	@NotBlank(message = "customer_fitnessLevel  should not be blank")
	@NotNull(message = "customer_fitnessLevel  should not be null")
	private String customer_fitnessLevel;
	@NotBlank(message = "customer_goal  should not be blank")
	@NotNull(message = "customer_goal  should not be null")
	private String customer_goal;
	
	
	@OneToOne(cascade =CascadeType.ALL)
	private Customer customer;
	

}
