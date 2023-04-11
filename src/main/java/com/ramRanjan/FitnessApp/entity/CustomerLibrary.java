package com.ramRanjan.FitnessApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class CustomerLibrary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int libraryId;
	@NotNull(message = "Library Name should not be null")
	private String libraryName;
	
	@ManyToMany(cascade =CascadeType.ALL )
	private List<WorkoutPlan> plan;
	
	
	
	
	

}
