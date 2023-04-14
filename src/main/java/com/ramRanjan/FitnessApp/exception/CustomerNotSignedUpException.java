package com.ramRanjan.FitnessApp.exception;

public class CustomerNotSignedUpException extends RuntimeException {

	private String messege;

	public String getMessege() {
		return messege;
	}

	public CustomerNotSignedUpException(String messege) {
		this.messege = messege;
	}
	
	
}