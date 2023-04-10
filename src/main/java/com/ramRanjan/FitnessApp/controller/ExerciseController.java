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
import com.ramRanjan.FitnessApp.dto.ExerciseDto;
import com.ramRanjan.FitnessApp.entity.Exercise;
import com.ramRanjan.FitnessApp.service.ExerciseService;

@RestController
@RequestMapping("/exercise")
public class ExerciseController 
{
	@Autowired
	private ExerciseService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<ExerciseDto>> saveExercise(@RequestBody Exercise exercise)
	{
		
		return service.saveExercise(exercise);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<ExerciseDto>> updateExercise(@RequestParam int id,@RequestBody Exercise exercise)
	{
		
		return service.updateExercise(id, exercise);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<ExerciseDto>> findExerciseById(@RequestParam int id)
	{
		
		return service.findExercisebyId(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ExerciseDto>> deleteExercisebyId(@RequestParam int id)
	{
		
		return service.deleteExerciseById(id);
	}
	
	
	
	
}
	

