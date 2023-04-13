package com.ramRanjan.FitnessApp.exception;

public class CustomerEmailAlreadyExistingException extends RuntimeException {
	
	private String message;
	public CustomerEmailAlreadyExistingException(String message)
	{
		this.message = message;
		
	}
	public String getMessage() {
		return message;
	}
	
	

}
