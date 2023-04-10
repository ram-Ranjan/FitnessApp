package com.ramRanjan.FitnessApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.CustomerLibraryDao;
import com.ramRanjan.FitnessApp.dto.CustomerLibraryDto;
import com.ramRanjan.FitnessApp.entity.CustomerLibrary;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;

@Service
public class CustomerLibraryService {
	
	@Autowired
	private CustomerLibraryDao dao;
	@Autowired
	private CustomerLibraryDto dto;
	
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> saveCustomerLibrary(CustomerLibrary library)
	{
		ResponseStructure<CustomerLibraryDto> responseStructure= new ResponseStructure<>();
		library=dao.saveCustomerLibrary(library);
		dto.setLibraryId(library.getLibraryId());
		dto.setLibraryName(library.getLibraryName());
		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Customer Library has been Saved");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<CustomerLibraryDto>>(responseStructure,HttpStatus.CREATED); 
	}
	
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> updateCustomerLibrary(int id,CustomerLibrary library)
	{
		library =dao.updateCustomerLibrary(id, library);
		if(library!=null) {
			dto.setLibraryId(library.getLibraryId());
			dto.setLibraryName(library.getLibraryName());
	
		ResponseStructure<CustomerLibraryDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Customer Library has been Updated");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<CustomerLibraryDto>>(responseStructure,HttpStatus.OK); 
	}
	else
		throw new IdNotFoundException("Customer Library Id Not Present");
	}
	
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> findCustomerLibrarybyId(int id)
	{
		
		CustomerLibrary library =dao.findCustomerLibraryById(id);
		if(library!=null) {
			dto.setLibraryId(library.getLibraryId());
			dto.setLibraryName(library.getLibraryName());
		
		ResponseStructure<CustomerLibraryDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Customer library has been Saved");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<CustomerLibraryDto>>(responseStructure,HttpStatus.FOUND); 
	}
	else
		throw new IdNotFoundException("Customer library Id Not Present");
	}
	
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> deleteCustomerLibraryById(int id)
	{
		CustomerLibrary library =dao.deleteCustomerLibraryById(id);
		if(library!=null) {
			dto.setLibraryId(library.getLibraryId());
			dto.setLibraryName(library.getLibraryName());
		
		ResponseStructure<CustomerLibraryDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Customer library has been Deleted");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<CustomerLibraryDto>>(responseStructure,HttpStatus.OK); 
	}
	else
		throw new IdNotFoundException("Customer library Id Not Present");
		
	}

	

}
