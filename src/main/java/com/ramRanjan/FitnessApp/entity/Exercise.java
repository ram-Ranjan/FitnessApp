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
	
	@NotBlank(message = "exerciseDescription  should not be blank")
	@NotNull(message = "exerciseDescription  should not be null")
	private String exerciseOverview;
	
	@NotBlank(message = "exerciseDescription  should not be blank")
	@NotNull(message = "exerciseDescription  should not be null")
	private String exerciseInstructions;
	
	@NotBlank(message = "exerciseDescription  should not be blank")
	private String exerciseEquipment;
	
	@Positive(message = "Exercise Reps should greater then 0")
	private int exerciseSets;
	
	@Positive(message = "Exercise Reps should greater then 0")
	private int exerciseRepsPerSet;
	@Positive(message = "Exercise duration should greater then 0")
	private int exerciseDurationInMinutes;
	@NotBlank(message = "exerciseMuscleTargeted  should not be blank")
	@NotNull(message = "exerciseMuscleTargeted  should not be null")
	private String exerciseMuscleTargeted;
	
	
}
