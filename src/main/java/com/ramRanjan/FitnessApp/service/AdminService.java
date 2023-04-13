package com.ramRanjan.FitnessApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.AdminDao;
import com.ramRanjan.FitnessApp.dto.AdminDto;
import com.ramRanjan.FitnessApp.entity.Admin;
import com.ramRanjan.FitnessApp.exception.AdminEmailAlreadyExistingException;
import com.ramRanjan.FitnessApp.exception.AdminEmailNotFoundException;
import com.ramRanjan.FitnessApp.exception.AdminIdNotFoundException;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao dao;
	@Autowired
	private AdminDto dto;
	
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(Admin admin)
	{	
		if(dao.findbyAdminEmail(admin.getAdminEmail())==null) {
		ResponseStructure<AdminDto> responseStructure= new ResponseStructure<>();
		admin=dao.saveAdmin(admin);
		
		dto.setAdminId(admin.getAdminId());
		dto.setAdminName(admin.getAdminName());
		dto.setAdminEmail(admin.getAdminEmail());
			
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Admin has been Saved");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure,HttpStatus.CREATED); 
		}
		else
			throw new AdminEmailAlreadyExistingException("Admin Email Already existing");
		}
	
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(int id,Admin updatedAdmin)
	{
		Admin existingAdmin =dao.findAdminById(id);
	if(existingAdmin!=null) {
		Admin adminWithEmail = dao.findbyAdminEmail(updatedAdmin.getAdminEmail());

		if(adminWithEmail==null) {
		
		updatedAdmin =dao.updateAdmin(id, updatedAdmin); 
		dto.setAdminId(updatedAdmin.getAdminId());
		dto.setAdminName(updatedAdmin.getAdminName());
		dto.setAdminEmail(updatedAdmin.getAdminEmail());
	
		ResponseStructure<AdminDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Admin has been Updated");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure,HttpStatus.OK); 
		}
		else
			throw new AdminEmailAlreadyExistingException("Admin Email Already existing");
		}
	else
		throw new AdminIdNotFoundException("Admin Id Not Present");
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> findAdminbyId(int id)
	{	
		Admin admin =dao.findAdminById(id);
		if(admin!=null) {
		dto.setAdminId(admin.getAdminId());
		dto.setAdminName(admin.getAdminName());
		dto.setAdminEmail(admin.getAdminEmail());
		ResponseStructure<AdminDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Admin has been Saved");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure,HttpStatus.FOUND); 
	}
	else
		throw new AdminIdNotFoundException("Admin Id Not Present");
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> findByAdminEmail(String adminEmail)
	{
		
		Admin admin =dao.findbyAdminEmail(adminEmail);
		if(admin!=null) {
		dto.setAdminId(admin.getAdminId());
		dto.setAdminName(admin.getAdminName());
		dto.setAdminEmail(admin.getAdminEmail());
		ResponseStructure<AdminDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Admin has been Saved");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure,HttpStatus.FOUND); 
	}
	else
		throw new AdminEmailNotFoundException("Admin Email Not Present");
	}
	
	
	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdminById(int id)
	{
		Admin admin =dao.deleteAdminById(id);
		if(admin!=null) {
		dto.setAdminId(admin.getAdminId());
		dto.setAdminName(admin.getAdminName());
		dto.setAdminEmail(admin.getAdminEmail());
		
		ResponseStructure<AdminDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Admin has been Deleted");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure,HttpStatus.OK); 
	}
	else
		throw new IdNotFoundException("Admin Id Not Present");
	}

}
