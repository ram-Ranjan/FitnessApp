package com.ramRanjan.FitnessApp.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ExerciseDto {
	
	
	private int exerciseId;
	private String exerciseName;
	private int exerciseReps;
	private int exerciseDurationInMinutes;
	private String exerciseMuscleTargeted;
	

}
