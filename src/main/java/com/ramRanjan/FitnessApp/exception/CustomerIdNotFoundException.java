package com.ramRanjan.FitnessApp.exception;

public class CustomerIdNotFoundException extends RuntimeException{
	
	private String message ;
	
	public CustomerIdNotFoundException(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}

}