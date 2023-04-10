/**
 * 
 */
package com.ramRanjan.FitnessApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.FitnessApp.entity.Exercise;
import com.ramRanjan.FitnessApp.repository.ExerciseRepo;

/**
 * @author ram-Ranjan
 *
 */

@Repository
public class ExerciseDao {
	
	@Autowired
	private ExerciseRepo repo;
	
	public Exercise saveExercise(Exercise exercise)
	{
		return repo.save(exercise);
	}
	
	
	
	public Exercise updateExercise(int id,Exercise plan)
	{
		Optional<Exercise> exercise = repo.findById(id);
		if(exercise.isPresent())
		{
			plan.setExerciseId(id);
			return repo.save(plan);
		}
		return null;
	}
	public Exercise findExercisebyId(int id)
	{
		Optional<Exercise> exercise = repo.findById(id);
		if(exercise.isPresent())
		{
			return exercise.get();
		}
		return null;

	}
	public  Exercise deleteExerciseById(int id)
	{
		Optional<Exercise> exercise = repo.findById(id);
		if(exercise.isPresent())
		{
			repo.delete(exercise.get());
			return exercise.get();
		}
		return null;
	}
	
	

}
