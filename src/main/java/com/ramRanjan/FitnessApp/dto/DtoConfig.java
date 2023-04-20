package com.ramRanjan.FitnessApp.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ramRanjan.FitnessApp.entity.Admin;
import com.ramRanjan.FitnessApp.entity.Customer;
import com.ramRanjan.FitnessApp.entity.CustomerSurvey;
import com.ramRanjan.FitnessApp.entity.Exercise;
import com.ramRanjan.FitnessApp.entity.WorkoutPlan;


@Component
public class DtoConfig {
	
	@Autowired 
	AdminDto adminDto;
	
	@Autowired 
	ExerciseDto exerciseDto;
	
	@Autowired
	CustomerDto customerDto;
	
	@Autowired
	CustomerSurveyDto surveyDto;
	@Autowired
	WorkoutPlanDto workoutDto;
	
	
	
	public AdminDto getAdminDtoAttributes(Admin admin)
	{
		
		adminDto.setAdminId(admin.getAdminId());
		adminDto.setAdminName(admin.getAdminName());
		adminDto.setAdminContact(admin.getAdminContact());
		adminDto.setAdminEmail(admin.getAdminEmail());
		
		return adminDto;
	}
	
	
	public WorkoutPlanDto getWorkoutDtoAttributes(WorkoutPlan plan) {
		
		workoutDto.setWorkoutId(plan.getWorkoutId());
		workoutDto.setWorkoutName(plan.getWorkoutName());
		workoutDto.setWorkoutDurationInWeeks(plan.getWorkoutDurationInWeeks());
		workoutDto.setWorkoutsPerWeek(plan.getWorkoutsPerWeek());
		workoutDto.setWorkoutEquipmentRequired(plan.getWorkoutEquipmentRequired());
		workoutDto.setWorkoutDescription(plan.getWorkoutDescription());
		workoutDto.setWorkoutDifficulty(plan.getWorkoutDifficulty());
		workoutDto.setWorkoutPrice(plan.getWorkoutPrice());
		workoutDto.setExercises(plan.getExercises());
		return workoutDto;
		
	}
	
	public ExerciseDto getExerciseDtoAttributes(Exercise exercise) {
		
		exerciseDto.setExerciseId(exercise.getExerciseId());
		exerciseDto.setExerciseName(exercise.getExerciseName());
		exerciseDto.setExerciseOverview(exercise.getExerciseOverview());
		exerciseDto.setExerciseInstructions(exercise.getExerciseInstructions());
		exerciseDto.setExerciseEquipment(exercise.getExerciseEquipment());
		exerciseDto.setExerciseRepsPerSet(exercise.getExerciseRepsPerSet());
		exerciseDto.setExerciseDurationInMinutes(exercise.getExerciseDurationInMinutes());
		exerciseDto.setExerciseMuscleTargeted(exercise.getExerciseMuscleTargeted());
	
		return exerciseDto;
	}
	
	
	public CustomerDto getCustomerDtoAttributes(Customer customer) {

		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setCustomerName(customer.getCustomerName());
		customerDto.setCustomerContact(customer.getCustomerContact());
		customerDto.setCustomerEmail(customer.getCustomerEmail());
		return customerDto;
	}
	
	public CustomerSurveyDto getCustomerSurveyDtoAttributes(CustomerSurvey survey) {
		surveyDto.setCustomer_surveyId(survey.getCustomer_surveyId());
		surveyDto.setCustomer_heightInMeters(survey.getCustomer_heightInMeters());
		surveyDto.setCustomer_weightInKgs(survey.getCustomer_weightInKgs());
		surveyDto.setCustomer_fitnessLevel(survey.getCustomer_fitnessLevel());
		surveyDto.setCustomer_goal(survey.getCustomer_goal());	
		surveyDto.setBMI(survey.getCustomer_weightInKgs()/(survey.getCustomer_heightInMeters()*survey.getCustomer_heightInMeters()));
		return surveyDto;
	}
	
	

}
