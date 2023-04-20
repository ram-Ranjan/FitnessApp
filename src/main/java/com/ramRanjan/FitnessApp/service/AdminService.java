package com.ramRanjan.FitnessApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.AdminDao;
import com.ramRanjan.FitnessApp.dto.AdminDto;
import com.ramRanjan.FitnessApp.dto.DtoConfig;
import com.ramRanjan.FitnessApp.entity.Admin;
import com.ramRanjan.FitnessApp.exception.AdminEmailAlreadyExistingException;
import com.ramRanjan.FitnessApp.exception.AdminEmailNotFoundException;
import com.ramRanjan.FitnessApp.exception.AdminHasNotSignedUpException;
import com.ramRanjan.FitnessApp.exception.AdminIdNotFoundException;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;

@Service
public class AdminService {

	@Autowired
	private AdminDao dao;
	@Autowired
	private AdminDto dto;
	@Autowired
	private DtoConfig dtoConfig;

	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(Admin admin) {
		if (dao.findbyAdminEmail(admin.getAdminEmail()) == null) {
			ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
			admin = dao.saveAdmin(admin);

			dto = dtoConfig.getAdminDtoAttributes(admin);

			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Admin has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure, HttpStatus.CREATED);
		} else
			throw new AdminEmailAlreadyExistingException("Admin Email Already existing");
	}

	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(int id, Admin updatedAdmin) {
		Admin existingAdmin = dao.findAdminById(id);
		if (existingAdmin != null) {
			Admin adminWithEmail = dao.findbyAdminEmail(updatedAdmin.getAdminEmail());

			if (adminWithEmail == null) {

				existingAdmin.setAdminName(updatedAdmin.getAdminName() != null ? updatedAdmin.getAdminName()
						: existingAdmin.getAdminName());
				existingAdmin.setAdminEmail(updatedAdmin.getAdminEmail() != null ? updatedAdmin.getAdminEmail()
						: existingAdmin.getAdminEmail());
				existingAdmin.setAdminContact(updatedAdmin.getAdminContact() >0 ? updatedAdmin.getAdminContact()
						: existingAdmin.getAdminContact());

				updatedAdmin = dao.updateAdmin(id, existingAdmin);
				dto = dtoConfig.getAdminDtoAttributes(updatedAdmin);

				ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("Admin has been Updated");
				responseStructure.setData(dto);
				return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure, HttpStatus.OK);
			} else
				throw new AdminEmailAlreadyExistingException("Admin Email Already existing");
		} else
			throw new AdminIdNotFoundException("Admin Id Not Present");
	}

	public ResponseEntity<ResponseStructure<AdminDto>> findAdminbyId(int id) {
		Admin admin = dao.findAdminById(id);
		if (admin != null) {

			dto = dtoConfig.getAdminDtoAttributes(admin);

			ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Admin has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new AdminIdNotFoundException("Admin Id Not Present");
	}

	public ResponseEntity<ResponseStructure<AdminDto>> findByAdminEmail(String adminEmail) {

		Admin admin = dao.findbyAdminEmail(adminEmail);
		if (admin != null) {
			dto = dtoConfig.getAdminDtoAttributes(admin);

			ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Admin has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new AdminEmailNotFoundException("Admin Email Not Present");
	}

	public ResponseEntity<ResponseStructure<AdminDto>> findAdminByEmailAndPassword(String adminEmail,
			String adminPassword) {

		Admin admin = dao.findAdminByEmailAndPassword(adminEmail, adminPassword);
		if (admin != null) {
			dto=dtoConfig.getAdminDtoAttributes(admin);

			ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Admin has been Saved");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new AdminHasNotSignedUpException("Admin  Not Exist with given email and password");
	}

	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdminById(int id) {
		Admin admin = dao.deleteAdminById(id);
		if (admin != null) {
			dto=dtoConfig.getAdminDtoAttributes(admin);


			ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Admin has been Deleted");
			responseStructure.setData(dto);
			return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure, HttpStatus.OK);
		} else
			throw new IdNotFoundException("Admin Id Not Present");
	}

}
