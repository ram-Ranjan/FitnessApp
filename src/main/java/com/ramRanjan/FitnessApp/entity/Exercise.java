package com.ramRanjan.FitnessApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int exerciseId;
	@NotEmpty
	private String exerciseName;
	@NotNull
	private int exerciseReps;
	@NotBlank
	private int exerciseDurationInMinutes;
	@NotEmpty
	private String exerciseMuscleTargeted;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "exercise")
	private List<WorkoutPlan> workoutPlan;
	

}
