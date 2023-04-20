package com.ramRanjan.FitnessApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.AdminDao;
import com.ramRanjan.FitnessApp.dao.WorkoutPlanDao;
import com.ramRanjan.FitnessApp.dto.DtoConfig;
import com.ramRanjan.FitnessApp.dto.WorkoutPlanDto;
import com.ramRanjan.FitnessApp.entity.Admin;
import com.ramRanjan.FitnessApp.entity.WorkoutPlan;
import com.ramRanjan.FitnessApp.exception.AdminIdNotFoundException;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;
import com.ramRanjan.FitnessApp.exception.NoWorkoutsFoundException;

@Service
public class WorkoutPlanService {

	@Autowired
	private WorkoutPlanDao dao;
	@Autowired
	private WorkoutPlanDto dto;

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private DtoConfig dtoConfig;

	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> saveWorkout(WorkoutPlan plan, int adminId) {
		ResponseStructure<WorkoutPlanDto> responseStructure = new ResponseStructure<>();

		Admin admin = adminDao.findAdminById(adminId);
		if (admin != null) {
			List<WorkoutPlan> workouts = new ArrayList<>();
			workouts.add(plan);
			workouts.addAll(admin.getPlan());
			admin.setPlan(workouts);

			plan = dao.saveWorkout(plan);
			dto = dtoConfig.getWorkoutDtoAttributes(plan);

			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Workout has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<WorkoutPlanDto>>(responseStructure, HttpStatus.CREATED);
		} else
			throw new AdminIdNotFoundException("Admin id not present");
	}

	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> updateWorkout(int id, WorkoutPlan updatedPlan) {
		WorkoutPlan existingPlan = dao.findWorkoutbyId(id);
		if (existingPlan != null) {

			existingPlan.setWorkoutId(id);
			existingPlan.setWorkoutName(updatedPlan.getWorkoutName() != null ? updatedPlan.getWorkoutName()
					: existingPlan.getWorkoutName());
			existingPlan.setWorkoutDescription(
					updatedPlan.getWorkoutDescription() != null ? updatedPlan.getWorkoutDescription()
							: existingPlan.getWorkoutDescription());
			existingPlan.setWorkoutDurationInWeeks(
					updatedPlan.getWorkoutDurationInWeeks() > 0 ? updatedPlan.getWorkoutDurationInWeeks()
							: existingPlan.getWorkoutDurationInWeeks());
			existingPlan.setWorkoutsPerWeek(updatedPlan.getWorkoutsPerWeek() > 0 ? updatedPlan.getWorkoutsPerWeek()
					: existingPlan.getWorkoutsPerWeek());
			existingPlan.setWorkoutEquipmentRequired(
					updatedPlan.getWorkoutEquipmentRequired() != null ? updatedPlan.getWorkoutEquipmentRequired()
							: existingPlan.getWorkoutEquipmentRequired());
			existingPlan.setWorkoutDifficulty(
					updatedPlan.getWorkoutDifficulty() != null ? updatedPlan.getWorkoutDifficulty()
							: existingPlan.getWorkoutDifficulty());
			existingPlan.setWorkoutPrice(updatedPlan.getWorkoutPrice() != 0 ? updatedPlan.getWorkoutPrice()
					: existingPlan.getWorkoutPrice());
			existingPlan.setExercises(
					updatedPlan.getExercises() != null ? updatedPlan.getExercises() : existingPlan.getExercises());

			updatedPlan = dao.updateWorkout(id, existingPlan);

			dto = dtoConfig.getWorkoutDtoAttributes(updatedPlan);

			ResponseStructure<WorkoutPlanDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Workout has been Updated");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<WorkoutPlanDto>>(responseStructure, HttpStatus.OK);
		} else
			throw new IdNotFoundException("Workout Id Not Present");
	}

	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> findWorkoutbyId(int id) {

		WorkoutPlan plan = dao.findWorkoutbyId(id);
		if (plan != null) {

			dto = dtoConfig.getWorkoutDtoAttributes(plan);

			ResponseStructure<WorkoutPlanDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Workout has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<WorkoutPlanDto>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new IdNotFoundException("Workout Id Not Present");
	}

	public ResponseEntity<ResponseStructure<List<WorkoutPlanDto>>> find(String workoutDifficulty) {
		List<WorkoutPlan> planList = dao.findWorkoutBasedOnDifficulty(workoutDifficulty);
		List<WorkoutPlanDto> dtoList = new ArrayList<>();

		for (WorkoutPlan plan : planList) {
			dto = dtoConfig.getWorkoutDtoAttributes(plan);
			dtoList.add(dto);
		}

		ResponseStructure<List<WorkoutPlanDto>> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("Workout Found Based on Difficulty");
		structure.setData(dtoList);

		return new ResponseEntity<ResponseStructure<List<WorkoutPlanDto>>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<WorkoutPlanDto>> deleteWorkoutById(int adminId, int id) {

		Admin admin = adminDao.findAdminById(adminId);
		if (admin != null) {

			WorkoutPlan plan = dao.findWorkoutbyId(id);
			admin.setPlan(null);
			if (plan != null) {

				dto = dtoConfig.getWorkoutDtoAttributes(plan);
				dao.deleteWorkoutById(id);

				ResponseStructure<WorkoutPlanDto> responseStructure = new ResponseStructure<>();
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("Workout has been Deleted");
				responseStructure.setData(dto);
				return new ResponseEntity<ResponseStructure<WorkoutPlanDto>>(responseStructure, HttpStatus.OK);
			} else
				throw new IdNotFoundException("Workout Id Not Present");
		} else
			throw new AdminIdNotFoundException("Admin Id Not Present");
	}

	public ResponseEntity<ResponseStructure<List<WorkoutPlan>>> getAllWorkoutPlans() {

		List<WorkoutPlan> list = dao.getAllWorkoutPlans();
		if (list != null) {
			ResponseStructure<List<WorkoutPlan>> structure = new ResponseStructure<List<WorkoutPlan>>();

			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("All Workouts data is displayed");
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<WorkoutPlan>>>(structure, HttpStatus.FOUND);
		} else
			throw new NoWorkoutsFoundException("No Workouts added");

	}

}
