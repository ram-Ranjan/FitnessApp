package com.ramRanjan.FitnessApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@NotNull(message = "Admin Name should not be null")
	private String adminName;
	@NotEmpty(message = "Admin Password should not be Empty")
	private String adminPassword;
	@Email(message = "Email seems to be in incorrect format")
	private String adminEmail;
	
	@OneToMany(cascade =CascadeType.ALL )
	private List<WorkoutPlan> plan;
	
	
	

}
