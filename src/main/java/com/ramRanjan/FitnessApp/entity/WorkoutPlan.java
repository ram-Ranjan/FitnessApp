package com.ramRanjan.FitnessApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Entity
@Data
public class WorkoutPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workoutId;
	@NotNull(message = "Workout Description shouldnt be Null")
	@NotBlank(message = "Workout name shouldnt be empty")
	private String workoutName;
	@NotBlank(message = "Workout name shouldnt be empty")
	@NotNull(message = "Workout Description shouldnt be Null")
	private String workoutDescription;
	
	@PositiveOrZero(message = "workoutDurationInWeeks shouldnt be greater than 1")
	private int workoutDurationInWeeks;
	@Positive(message = "workoutDurationInWeeks shouldnt be greater than 1 and less than 8")
	@Max(7)
	private int workoutsPerWeek;
	
	@NotNull(message = "Workout Description shouldnt be Null")
	@NotBlank(message = "Workout name shouldnt be empty")
	private String workoutEquipmentRequired;
	
	@NotBlank(message = "Workout name shouldnt be empty")
	@NotNull(message = "Workout Description shouldnt be Null")
	private String workoutDifficulty;
	
	@PositiveOrZero(message = "Workout Price should be positive")
	private double workoutPrice;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Exercise> exercises;

	
	
	

}
