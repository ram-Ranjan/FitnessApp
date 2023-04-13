package com.ramRanjan.FitnessApp.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ramRanjan.FitnessApp.entity.WorkoutPlan;

import lombok.Data;

@Data
@Component
public class CustomerLibraryDto {
	
	private int libraryId;
	private String libraryName;
	
	private List<WorkoutPlan> plan;
	
	

}
