package com.ramRanjan.FitnessApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ramRanjan.FitnessApp.entity.WorkoutPlan;

public interface WorkoutPlanRepo extends JpaRepository<WorkoutPlan, Integer>{

	@Query("Select  a from WorkoutPlan a where a.workoutDifficulty=?1")
	public List<WorkoutPlan>findWorkoutBasedOnDifficulty(String workoutDifficulty);
}
 