package com.ramRanjan.FitnessApp.exception;

public class WorkoutIdNotFoundException extends RuntimeException{

	private String message ;
	
	public WorkoutIdNotFoundException(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}

}