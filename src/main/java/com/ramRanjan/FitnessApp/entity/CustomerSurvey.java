package com.ramRanjan.FitnessApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
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
	private int customer_height;
	@Positive
	private int customer_weight;
	@NotEmpty
	private String cusotmer_fitnessLevel;
	@NotNull
	private String customer_goal;
	
	@OneToOne(cascade =CascadeType.ALL ,mappedBy ="customerSurvey")
	private Customer customer;

}
