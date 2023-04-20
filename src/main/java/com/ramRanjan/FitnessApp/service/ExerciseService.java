package com.ramRanjan.FitnessApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.ExerciseDao;
import com.ramRanjan.FitnessApp.dao.WorkoutPlanDao;
import com.ramRanjan.FitnessApp.dto.DtoConfig;
import com.ramRanjan.FitnessApp.dto.ExerciseDto;
import com.ramRanjan.FitnessApp.entity.Exercise;
import com.ramRanjan.FitnessApp.entity.WorkoutPlan;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;

@Service
public class ExerciseService {

	@Autowired
	private ExerciseDao dao;
	@Autowired
	private ExerciseDto dto;
	@Autowired
	WorkoutPlanDao workoutDao;

	@Autowired
	private DtoConfig dtoConfig;

	public ResponseEntity<ResponseStructure<ExerciseDto>> saveExercise(Exercise exercise, int workoutId) {
		ResponseStructure<ExerciseDto> responseStructure = new ResponseStructure<>();

		WorkoutPlan workoutPlan = workoutDao.findWorkoutbyId(workoutId);
		if (workoutPlan != null) {
			List<Exercise> exerciseList = new ArrayList<>();
			exerciseList.add(exercise);
			workoutPlan.setExercises(exerciseList);

			exercise = dao.saveExercise(exercise);
			dto = dtoConfig.getExerciseDtoAttributes(exercise);

			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Exercise has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<ExerciseDto>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundException("Workout Id Not Found Exception");
		}
	}

	public ResponseEntity<ResponseStructure<ExerciseDto>> updateExercise(int id, Exercise updatedExercise) {
		Exercise existingExercise = dao.findExercisebyId(id);
		if (existingExercise != null) {

			existingExercise
					.setExerciseName(updatedExercise.getExerciseName() != null ? updatedExercise.getExerciseName()
							: existingExercise.getExerciseName());
			existingExercise.setExerciseDurationInMinutes(
					updatedExercise.getExerciseDurationInMinutes() > 0 ? updatedExercise.getExerciseDurationInMinutes()
							: existingExercise.getExerciseDurationInMinutes());
			existingExercise.setExerciseEquipment(
					updatedExercise.getExerciseEquipment() != null ? updatedExercise.getExerciseEquipment()
							: existingExercise.getExerciseEquipment());
			existingExercise.setExerciseInstructions(
					updatedExercise.getExerciseInstructions() != null ? updatedExercise.getExerciseInstructions()
							: existingExercise.getExerciseInstructions());
			existingExercise.setExerciseMuscleTargeted(
					updatedExercise.getExerciseMuscleTargeted() != null ? updatedExercise.getExerciseMuscleTargeted()
							: existingExercise.getExerciseMuscleTargeted());
			existingExercise.setExerciseOverview(
					updatedExercise.getExerciseOverview() != null ? updatedExercise.getExerciseOverview()
							: existingExercise.getExerciseOverview());
			existingExercise.setExerciseRepsPerSet(
					updatedExercise.getExerciseRepsPerSet() > 0 ? updatedExercise.getExerciseRepsPerSet()
							: existingExercise.getExerciseRepsPerSet());
			existingExercise.setExerciseSets(updatedExercise.getExerciseSets() > 0 ? updatedExercise.getExerciseSets()
					: existingExercise.getExerciseSets());

			updatedExercise = dao.updateExercise(id, existingExercise);
			dto = dtoConfig.getExerciseDtoAttributes(updatedExercise);

			ResponseStructure<ExerciseDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Exercise has been Updated");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<ExerciseDto>>(responseStructure, HttpStatus.OK);
		} else
			throw new IdNotFoundException("Exercise Id Not Present");
	}

	public ResponseEntity<ResponseStructure<ExerciseDto>> findExercisebyId(int id) {

		Exercise exercise = dao.findExercisebyId(id);
		if (exercise != null) {
			dto = dtoConfig.getExerciseDtoAttributes(exercise);

			ResponseStructure<ExerciseDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("exercise has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<ExerciseDto>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new IdNotFoundException("Exercise Id Not Present");
	}

	public ResponseEntity<ResponseStructure<ExerciseDto>> deleteExerciseById(int id) {
		Exercise exercise = dao.deleteExerciseById(id);
		if (exercise != null) {
			dto = dtoConfig.getExerciseDtoAttributes(exercise);

			ResponseStructure<ExerciseDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Exercise has been Deleted");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<ExerciseDto>>(responseStructure, HttpStatus.OK);
		} else
			throw new IdNotFoundException("Exercise Id Not Present");

	}

}
