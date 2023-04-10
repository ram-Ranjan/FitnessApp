package com.ramRanjan.FitnessApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dto.WorkoutPlanDto;
import com.ramRanjan.FitnessApp.entity.WorkoutPlan;
import com.ramRanjan.FitnessApp.service.WorkoutPlanService;

@RestController
@RequestMapping("/workout")
public class WorkoutPlanController 
{
	@Autowired
	private WorkoutPlanService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> saveWorkout(@RequestBody WorkoutPlan plan)
	{
		
		return service.saveWorkout(plan);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> updateWorkout(@RequestParam int id,@RequestBody WorkoutPlan plan)
	{
		
		return service.updateWorkout(id, plan);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> findWorkoutById(@RequestParam int id)
	{
		
		return service.findWorkoutbyId(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> deleteWorkoutbyId(@RequestParam int id)
	{
		
		return service.deleteWorkoutById(id);
	}
	
	
	
	
}
	

