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
	@NotNull
	private String customerName;
	@Email
	private String customerEmail;
	@NotEmpty
	private String customerPassword; 
	
	@OneToOne(cascade =CascadeType.ALL )
	private CustomerSurvey customerSurvey;
	
	@OneToOne(cascade =CascadeType.ALL )
	private CustomerLibrary library;
	
	

}
