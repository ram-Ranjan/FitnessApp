package com.ramRanjan.FitnessApp.exception;

public class AdminEmailNotFoundException extends RuntimeException {
	
	private String message;
	public AdminEmailNotFoundException(String message)
	{
		this.message = message;
		
	}
	public String getMessage() {
		return message;
	}
	
	

}
