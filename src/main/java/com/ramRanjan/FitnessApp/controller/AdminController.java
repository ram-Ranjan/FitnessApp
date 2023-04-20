package com.ramRanjan.FitnessApp.controller;

import javax.validation.Valid;

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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService service;

	@ApiOperation(value = "Save Admin", notes = "API is used to save Admin ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 400, message = "Id not found for the given Admin ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(@Valid @RequestBody Admin admin) {

		return service.saveAdmin(admin);
	}

	@ApiOperation(value = "Update Admin", notes = "API is used to save Admin ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Updated"),
			@ApiResponse(code = 400, message = "Id not found for the given Admin ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(@Valid @RequestParam int adminId,
			@RequestBody Admin admin) {

		return service.updateAdmin(adminId, admin);
	}

	@ApiOperation(value = "Find Admin Based on Id", notes = "API is used to Find Admin ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Found"),
			@ApiResponse(code = 400, message = "Id not found for the given Admin ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<AdminDto>> findAdminById(@RequestParam int adminId) {

		return service.findAdminbyId(adminId);
	}

	@ApiOperation(value = "Find Admin Based on Email", notes = "API is used to Find Admin ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Found"),
			@ApiResponse(code = 400, message = "Email not found for the given adminEmail") })
	@GetMapping("/email")
	public ResponseEntity<ResponseStructure<AdminDto>> findByAdminEmail(@RequestParam String adminEmail) {

		return service.findByAdminEmail(adminEmail);
	}

	@ApiOperation(value = "Login Admin Based on Email and Password", notes = "API is used to Find Admin ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Found"),
			@ApiResponse(code = 400, message = "Email not found for the given adminEmail") })
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<AdminDto>> findAdminByEmailAndPassword(
			@Valid @RequestParam String adminEmail, @Valid @RequestParam String adminPassword) {
		return service.findAdminByEmailAndPassword(adminEmail, adminPassword);
	}

	@ApiOperation(value = "Delete Admin Based on Id", notes = "API is used to Delete Admin ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully Deleted"),
			@ApiResponse(code = 400, message = "Id not found for the given Admin ID") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(@RequestParam int adminId) {
		return service.deleteAdminById(adminId);
	}

}
