package com.ramRanjan.FitnessApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.ExerciseDao;
import com.ramRanjan.FitnessApp.dto.ExerciseDto;
import com.ramRanjan.FitnessApp.entity.Exercise;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;

@Service
public class ExerciseService {
	
	@Autowired
	private ExerciseDao dao;
	@Autowired
	private ExerciseDto dto;
	
	public ResponseEntity<ResponseStructure<ExerciseDto>> saveExercise(Exercise exercise)
	{
		ResponseStructure<ExerciseDto> responseStructure= new ResponseStructure<>();
		exercise=dao.saveExercise(exercise);
		dto.setExerciseId(exercise.getExerciseId());
		dto.setExerciseName(exercise.getExerciseName());
		dto.setExerciseReps(exercise.getExerciseReps());
		dto.setExerciseDurationInMinutes(exercise.getExerciseDurationInMinutes());
		dto.setExerciseMuscleTargeted(exercise.getExerciseMuscleTargeted());
		

		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Exercise has been Saved");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<ExerciseDto>>(responseStructure,HttpStatus.CREATED); 
	}
	
	public ResponseEntity<ResponseStructure<ExerciseDto>> updateExercise(int id,Exercise exercise)
	{
		exercise =dao.updateExercise(id, exercise);
		if(exercise!=null) {
		dto.setExerciseId(exercise.getExerciseId());
		dto.setExerciseName(exercise.getExerciseName());
		dto.setExerciseReps(exercise.getExerciseReps());
		dto.setExerciseDurationInMinutes(exercise.getExerciseDurationInMinutes());
		dto.setExerciseMuscleTargeted(exercise.getExerciseMuscleTargeted());
		
		ResponseStructure<ExerciseDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Exercise has been Updated");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<ExerciseDto>>(responseStructure,HttpStatus.OK); 
	}
	else
		throw new IdNotFoundException("Exercise Id Not Present");
	}
	
	public ResponseEntity<ResponseStructure<ExerciseDto>> findExercisebyId(int id)
	{
		
		Exercise exercise =dao.findExercisebyId(id);
		if(exercise!=null) {
		dto.setExerciseId(exercise.getExerciseId());
		dto.setExerciseName(exercise.getExerciseName());
		dto.setExerciseReps(exercise.getExerciseReps());
		dto.setExerciseDurationInMinutes(exercise.getExerciseDurationInMinutes());
		dto.setExerciseMuscleTargeted(exercise.getExerciseMuscleTargeted());
		
		ResponseStructure<ExerciseDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("exercise has been Saved");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<ExerciseDto>>(responseStructure,HttpStatus.FOUND); 
	}
	else
		throw new IdNotFoundException("Exercise Id Not Present");
	}
	
	public ResponseEntity<ResponseStructure<ExerciseDto>> deleteExerciseById(int id)
	{
		Exercise exercise   =dao.deleteExerciseById(id);
		if(exercise!=null) {
		dto.setExerciseId(exercise.getExerciseId());
		dto.setExerciseName(exercise.getExerciseName());
		dto.setExerciseReps(exercise.getExerciseReps());
		dto.setExerciseDurationInMinutes(exercise.getExerciseDurationInMinutes());
		dto.setExerciseMuscleTargeted(exercise.getExerciseMuscleTargeted());
		
		ResponseStructure<ExerciseDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Exercise has been Deleted");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<ExerciseDto>>(responseStructure,HttpStatus.OK); 
	}
	else
		throw new IdNotFoundException("Exercise Id Not Present");
		
	}



}
