package com.ramRanjan.FitnessApp.exception;

public class CustomerNotFoundByEmailException extends RuntimeException{
	
	private String messege;

	public String getMessege() {
		return messege;
	}

	public CustomerNotFoundByEmailException(String messege) {
		this.messege = messege;
	}
	
	
}
