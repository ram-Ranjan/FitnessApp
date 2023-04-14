package com.ramRanjan.FitnessApp.exception;

public class AdminHasNotSignedUpException extends RuntimeException {
	
	private String message ;
	
	public AdminHasNotSignedUpException(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}

}