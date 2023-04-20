package com.ramRanjan.FitnessApp.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ExerciseDto {
	
	
	private int exerciseId;
	private String exerciseName;
	private String exerciseOverview;
	private String exerciseInstructions;
	private String exerciseEquipment;
	private int exerciseRepsPerSet;
	private int exerciseDurationInMinutes;
	private String exerciseMuscleTargeted;
	

}
