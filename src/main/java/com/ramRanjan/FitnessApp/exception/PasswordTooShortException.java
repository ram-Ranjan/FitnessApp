package com.ramRanjan.FitnessApp.exception;

public class PasswordTooShortException extends RuntimeException {
	
	private String message ;
	
	public PasswordTooShortException(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
	

}
