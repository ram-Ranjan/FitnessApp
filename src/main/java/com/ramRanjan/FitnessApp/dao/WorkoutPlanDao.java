/**
 * 
 */
package com.ramRanjan.FitnessApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.FitnessApp.entity.CustomerLibrary;
import com.ramRanjan.FitnessApp.entity.WorkoutPlan;
import com.ramRanjan.FitnessApp.repository.WorkoutPlanRepo;

/**
 * @author ram-Ranjan
 *
 */

@Repository
public class WorkoutPlanDao {
	
	@Autowired
	private WorkoutPlanRepo repo;
	
	public WorkoutPlan saveWorkout(WorkoutPlan plan)
	{
		return repo.save(plan);
	}
	
	
	
	public WorkoutPlan updateWorkout(int id,WorkoutPlan plan)
	{
		Optional<WorkoutPlan> plan2 = repo.findById(id);
		if(plan2.isPresent())
		{
			plan.setWorkoutId(id);
			return repo.save(plan);
		}
		return null;
	}
	public WorkoutPlan findWorkoutbyId(int id)
	{
		Optional<WorkoutPlan> plan = repo.findById(id);
		if(plan.isPresent())
		{
			return plan.get();
		}
		return null;

	}
	public  WorkoutPlan deleteWorkoutById(int id)
	{
		Optional<WorkoutPlan> plan = repo.findById(id);
		if(plan.isPresent())
		{
			repo.delete(plan.get());
			return plan.get();
		}
		return null;
	}
	

	public List<WorkoutPlan> getAllWorkoutPlans()
	{
		return repo.findAll();
	}

	
	

}
