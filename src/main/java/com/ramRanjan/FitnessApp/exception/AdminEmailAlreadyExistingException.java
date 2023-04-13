package com.ramRanjan.FitnessApp.exception;

public class AdminEmailAlreadyExistingException extends RuntimeException {
	
	private String message;
	public AdminEmailAlreadyExistingException(String message)
	{
		this.message = message;
		
	}
	public String getMessage() {
		return message;
	}
	
	

}
