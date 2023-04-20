package com.ramRanjan.FitnessApp.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ramRanjan.FitnessApp.entity.Exercise;

import lombok.Data;

@Data
@Component
public class WorkoutPlanDto {

	private int workoutId;
	private String workoutName;
	private String workoutDescription;
	private int workoutDurationInWeeks;
	private int workoutsPerWeek;
	private String workoutEquipmentRequired;
	private double workoutPrice;
	private String workoutDifficulty;

	private List<Exercise> exercises;
}
