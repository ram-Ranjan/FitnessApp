package com.ramRanjan.FitnessApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.WorkoutPlanDao;
import com.ramRanjan.FitnessApp.dto.WorkoutPlanDto;
import com.ramRanjan.FitnessApp.entity.WorkoutPlan;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;

@Service
public class WorkoutPlanService {
	
	@Autowired
	private WorkoutPlanDao dao;
	@Autowired
	private WorkoutPlanDto dto;
	
	
	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> saveWorkout(WorkoutPlan plan)
	{
		ResponseStructure<WorkoutPlanDto> responseStructure= new ResponseStructure<>();
		
		
		plan=dao.saveWorkout(plan);
		dto.setWorkoutId(plan.getWorkoutId());
		dto.setWorkoutName(plan.getWorkoutName());
		dto.setWorkoutDescription(plan.getWorkoutDescription());
		dto.setWorkoutPrice(plan.getWorkoutPrice());
		dto.setExercises(plan.getExercises());

		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Workout has been Saved");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<WorkoutPlanDto>>(responseStructure,HttpStatus.CREATED); 
	}
	
	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> updateWorkout(int id,WorkoutPlan plan)
	{
		plan =dao.findWorkoutbyId(id);
		if(plan!=null) {
		dto.setWorkoutId(plan.getWorkoutId());
		dto.setWorkoutName(plan.getWorkoutName());
		dto.setWorkoutDescription(plan.getWorkoutDescription());
		dto.setWorkoutPrice(plan.getWorkoutPrice());
		dto.setExercises(plan.getExercises());
		
		ResponseStructure<WorkoutPlanDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Workout has been Updated");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<WorkoutPlanDto>>(responseStructure,HttpStatus.OK); 
	}
	else
		throw new IdNotFoundException("Workout Id Not Present");
	}
	
	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> findWorkoutbyId(int id)
	{
		
		WorkoutPlan plan =dao.findWorkoutbyId(id);
		if(plan!=null) {
		dto.setWorkoutId(plan.getWorkoutId());
		dto.setWorkoutName(plan.getWorkoutName());
		dto.setWorkoutDescription(plan.getWorkoutDescription());
		dto.setWorkoutPrice(plan.getWorkoutPrice());
		dto.setExercises(plan.getExercises());
		
		ResponseStructure<WorkoutPlanDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Workout has been Saved");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<WorkoutPlanDto>>(responseStructure,HttpStatus.FOUND); 
	}
	else
		throw new IdNotFoundException("Workout Id Not Present");
	}
	
	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> deleteWorkoutById(int id)
	{
		WorkoutPlan plan   =dao.deleteWorkoutById(id);
		if(plan!=null) {
			
		dto.setWorkoutId(plan.getWorkoutId());
		dto.setWorkoutName(plan.getWorkoutName());
		dto.setWorkoutDescription(plan.getWorkoutDescription());
		dto.setWorkoutPrice(plan.getWorkoutPrice());
		dto.setExercises(plan.getExercises());
		
		ResponseStructure<WorkoutPlanDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Workout has been Deleted");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<WorkoutPlanDto>>(responseStructure,HttpStatus.OK); 
	}
	else
		throw new IdNotFoundException("Workout Id Not Present");
		
	}
	
	
	public  ResponseEntity<ResponseStructure<List<WorkoutPlanDto>>> getAllWorkoutPlans()
	{
		List<WorkoutPlanDto> dtoList = new ArrayList<WorkoutPlanDto>();
		
		List<WorkoutPlan> list = dao.getAllWorkoutPlans();
		for(WorkoutPlan plan:list)
		{
			WorkoutPlanDto dto=new WorkoutPlanDto();
			dto.setWorkoutId(plan.getWorkoutId());
			dto.setWorkoutName(plan.getWorkoutName());
			dto.setWorkoutDescription(plan.getWorkoutDescription());
			dto.setWorkoutPrice(plan.getWorkoutPrice());	
			dto.setExercises(plan.getExercises());
			
			dtoList.add(dto);
		}
		
		ResponseStructure<List<WorkoutPlanDto>> structure = new ResponseStructure<List<WorkoutPlanDto>>();
		
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("All Workouts data is displayed");
		structure.setData(dtoList);
		return new ResponseEntity<ResponseStructure<List<WorkoutPlanDto>>>(structure,HttpStatus.FOUND);
		
		
	}
	


}
