package com.ramRanjan.FitnessApp.exception;

public class AdminIdNotFoundException extends RuntimeException{
	
	private String message ;
	
	public AdminIdNotFoundException(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}

}