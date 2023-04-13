package com.ramRanjan.FitnessApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@NotBlank
	@NotNull(message = "Admin Name should not be null or blank")
	private String adminName;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must contain at least one digit, one lowercase, one uppercase letter, one special character and must be at least 8 characters long")
	private String adminPassword;
	@NotBlank(message = "Admin Email should not be Empty")
	@Email(message = "Email seems to be in incorrect format")
	private String adminEmail;
	 
	@OneToMany(cascade =CascadeType.ALL )
	private List<WorkoutPlan> plan;
	

}
