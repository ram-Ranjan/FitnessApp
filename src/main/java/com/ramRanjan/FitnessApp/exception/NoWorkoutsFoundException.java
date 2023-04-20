package com.ramRanjan.FitnessApp.exception;

public class NoWorkoutsFoundException extends RuntimeException {

	private String message;

	public NoWorkoutsFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
