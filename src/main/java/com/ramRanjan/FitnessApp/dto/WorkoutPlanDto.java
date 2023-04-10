package com.ramRanjan.FitnessApp.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class WorkoutPlanDto {
	
	private int workoutId;
	private String workoutName;
	private String workoutDescription;
	private double workoutPrice;

}
