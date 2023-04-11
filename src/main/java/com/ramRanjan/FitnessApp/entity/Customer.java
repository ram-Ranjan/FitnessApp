package com.ramRanjan.FitnessApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@NotNull(message = "Customer Name should not be null")
	private String customerName;
	@Email(message = "Customer Email Seems to  be invalid")
	private String customerEmail;
	@NotEmpty(message = "Customer Password should not be Empty")
	private String customerPassword; 
	
	@OneToOne(cascade =CascadeType.ALL )
	private CustomerSurvey customerSurvey;
	
	@OneToOne(cascade =CascadeType.ALL )
	private CustomerLibrary library;
	
	

}
