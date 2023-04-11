package com.ramRanjan.FitnessApp.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ramRanjan.FitnessApp.config.ResponseStructure;

@RestControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> IdNotFound(IdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Id does not exist");
		structure.setData(ex.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<Object>> handleConstraintViolationException(
			javax.validation.ConstraintViolationException ex) {
		List<String> errors = new ArrayList<>();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errors.add(violation.getMessage(

			));
		}

		ResponseStructure<Object> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Field Validation Exception ");
		structure.setData(errors);

		return new ResponseEntity<ResponseStructure<Object>>(structure, HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ObjectError> list = ex.getAllErrors();
		HashMap<String, String> hashMap = new HashMap<>();
		for (ObjectError error : list) {
			String message = error.getDefaultMessage();
			String fieldname = ((FieldError) error).getField();
			hashMap.put(fieldname, message);
		}
		return new ResponseEntity<Object>(hashMap, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PasswordTooShortException.class)
	public ResponseEntity<ResponseStructure<String>> passwordException(PasswordTooShortException ex)
	{
		
		ResponseStructure<String> structure= new ResponseStructure<>();
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("Password too short Exception");
		structure.setData(ex.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
		
	}
	
	

}
