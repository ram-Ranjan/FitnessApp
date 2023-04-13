package com.ramRanjan.FitnessApp.exception;

public class ExerciseIdNotFoundException extends RuntimeException{
	
	private String message ;
	
	public ExerciseIdNotFoundException(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}

}