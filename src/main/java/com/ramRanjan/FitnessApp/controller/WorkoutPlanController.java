package com.ramRanjan.FitnessApp.controller;

import java.util.List;

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
import com.ramRanjan.FitnessApp.dto.WorkoutPlanDto;
import com.ramRanjan.FitnessApp.entity.WorkoutPlan;
import com.ramRanjan.FitnessApp.service.WorkoutPlanService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/workout")
public class WorkoutPlanController 
{
	@Autowired
	private WorkoutPlanService service;
	
	
	@ApiOperation(value = "Save Workout ", notes = "API is used to Save Workout ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
	@ApiResponse(code = 400, message = "Id not found for the given Workout ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> saveWorkout(@Valid @RequestBody WorkoutPlan plan,@RequestParam int adminId)
	{
		
		return service.saveWorkout(plan,adminId);
	}
	
	@ApiOperation(value = "Update Workout ", notes = "API is used to Save Workout ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Saved"),
	@ApiResponse(code = 400, message = "Id not found for the given Workout ID")})
	@PutMapping
	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> updateWorkout(@Valid @RequestParam int id,@Valid @RequestBody WorkoutPlan plan)
	{
		
		return service.updateWorkout(id, plan);
	}
	
	@ApiOperation(value = "Find Workout based on Id", notes = "API is used to Update Workout ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Updated"),
	@ApiResponse(code = 400, message = "Id not found for the given Workout ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> findWorkoutById(@RequestParam int id)
	{
		return service.findWorkoutbyId(id);
	}	
	
	@ApiOperation(value = "Find All Workout  ", notes = "API is used to Save Workout ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Found"),
	@ApiResponse(code = 400, message = "Id not found for the given Workout ID") })
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<WorkoutPlanDto>>> getAllWorkoutPlans()
	{
		return service.getAllWorkoutPlans();
	}
	
	
	@ApiOperation(value = "Delete Workout ", notes = "API is used to Delete Workout ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Delete"),
	@ApiResponse(code = 400, message = "Id not found for the given Workout ID") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> deleteWorkoutbyId(@RequestParam int adminId,@RequestParam int id)
	{
		
		return service.deleteWorkoutById(adminId,id);
	}
	
	
	
	
}
	

