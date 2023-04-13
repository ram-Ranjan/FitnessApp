package com.ramRanjan.FitnessApp.controller;

import javax.validation.Valid;

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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/exercise")
public class ExerciseController 
{
	@Autowired
	private ExerciseService service;
	
	
	@ApiOperation(value = "Save Exercise", notes = "API is used to Save exercise ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
	@ApiResponse(code = 400, message = "Id not found for the given exercise ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<ExerciseDto>> saveExercise(@Valid @RequestBody Exercise exercise,int workoutId)
	{
		
		return service.saveExercise(exercise,workoutId);
	}
	
	
	@ApiOperation(value = "Update Exercise ", notes = "API is used to Update exercise ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
	@ApiResponse(code = 400, message = "Id not found for the given exercise ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<ExerciseDto>> updateExercise(@Valid @RequestParam int id,@RequestBody Exercise exercise)
	{
		
		return service.updateExercise(id, exercise);
	}
	
	@ApiOperation(value = "Find Exercise based on Id", notes = "API is used to find exercise ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
	@ApiResponse(code = 400, message = "Id not found for the given exercise ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<ExerciseDto>> findExerciseById(@RequestParam int id)
	{
		
		return service.findExercisebyId(id);
	}
	
	
	@ApiOperation(value = "Delete  Exercise", notes = "API is used to Save Exercise ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
	@ApiResponse(code = 400, message = "Id not found for the given Exercise ID") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ExerciseDto>> deleteExercisebyId(@RequestParam int id)
	{
		
		return service.deleteExerciseById(id);
	}
	
	
	
	
}
	

