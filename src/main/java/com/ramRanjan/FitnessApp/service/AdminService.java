package com.ramRanjan.FitnessApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.AdminDao;
import com.ramRanjan.FitnessApp.dto.AdminDto;
import com.ramRanjan.FitnessApp.entity.Admin;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao dao;
	@Autowired
	private AdminDto dto;
	
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(Admin admin)
	{
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
	
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(int id,Admin admin)
	{
		admin =dao.updateAdmin(id, admin); 
	if(admin!=null) {
		dto.setAdminId(admin.getAdminId());
		dto.setAdminName(admin.getAdminName());
		dto.setAdminEmail(admin.getAdminEmail());
	
		ResponseStructure<AdminDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Admin has been Updated");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<AdminDto>>(responseStructure,HttpStatus.OK); 
	}
	else
		throw new IdNotFoundException("Admin Id Not Present");
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
		throw new IdNotFoundException("Admin Id Not Present");
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
