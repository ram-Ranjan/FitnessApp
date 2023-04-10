package com.ramRanjan.FitnessApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dto.AdminDto;
import com.ramRanjan.FitnessApp.entity.Admin;
import com.ramRanjan.FitnessApp.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(@RequestBody Admin admin)
	{
		
		return service.saveAdmin(admin);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(@RequestParam int id,@RequestBody Admin admin)
	{
		
		return service.updateAdmin(id, admin);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<AdminDto>> findAdminById(@RequestParam int id)
	{
		
		return service.findAdminbyId(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(@RequestParam int id)
	{
		
		return service.deleteAdminById(id);
	}
	
	
	
	
}
	

