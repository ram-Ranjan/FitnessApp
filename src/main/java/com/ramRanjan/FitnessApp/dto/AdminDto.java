package com.ramRanjan.FitnessApp.dto;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
public class AdminDto {
	
	
	
	private int adminId; 
	private String adminName;
	private String adminEmail;
	
	
	

}
