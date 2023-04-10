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
public class WorkoutPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workoutId;
	@NotEmpty(message = "Workout name shouldnt be empty")
	private String workoutName;
	@NotNull(message = "Workout Description shouldnt be Null")
	private String workoutDescription;
	@NotNull(message = "Workout Price shouldnt be Null")
	private double workoutPrice;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Exercise> exercise;
	

}
