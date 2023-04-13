package com.ramRanjan.FitnessApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Entity
@Data
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int exerciseId;
	@NotBlank(message = "exerciseName  should not be blank")
	@NotNull(message = "exerciseName  should not be null")
	private String exerciseName;
	@Positive(message = "Exercise Reps should greater then 0")
	private int exerciseReps;
	@Positive(message = "Exercise duration should greater then 0")
	private int exerciseDurationInMinutes;
	@NotBlank(message = "exerciseMuscleTargete  should not be blank")
	@NotNull(message = "exerciseMuscleTargeted  should not be null")
	private String exerciseMuscleTargeted;
	
	
}
