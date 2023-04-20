package com.ramRanjan.FitnessApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@NotBlank(message = "Customer Name should not be Blank")
	@NotNull(message = "Customer Name should not be null")
	private String customerName;
	@Min(value = 6000000000l, message = "Customer contact must be ten digits and start with 6,7,8 or  9")
    @Max(value = 9999999999L, message = "Customer contact must be ten digits and start with 6,7,8 or  9")
	private long customerContact;
	@NotBlank(message = "Customer Email should not be blank")
	@NotNull(message = "Customer Email should not be null")
	@Email(message = "Customer Email Seems to  be invalid")
	private String customerEmail;
	
	@NotBlank(message = "Customer Password should not be blank")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$", message = "Password must contain at least one digit, one lowercase, one uppercase letter, one special character and must be at least 6 characters long")
	private String customerPassword; 
	
	
	
	@OneToOne(cascade =CascadeType.ALL,mappedBy = "customer")
	private CustomerSurvey customerSurvey;
	
	@OneToOne(cascade =CascadeType.ALL )
	private CustomerLibrary library;
	
	
}
