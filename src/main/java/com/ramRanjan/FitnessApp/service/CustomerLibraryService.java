package com.ramRanjan.FitnessApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.FitnessApp.config.ResponseStructure;
import com.ramRanjan.FitnessApp.dao.CustomerDao;
import com.ramRanjan.FitnessApp.dao.CustomerLibraryDao;
import com.ramRanjan.FitnessApp.dao.WorkoutPlanDao;
import com.ramRanjan.FitnessApp.dto.CustomerLibraryDto;
import com.ramRanjan.FitnessApp.entity.Customer;
import com.ramRanjan.FitnessApp.entity.CustomerLibrary;
import com.ramRanjan.FitnessApp.entity.WorkoutPlan;
import com.ramRanjan.FitnessApp.exception.CustomerIdNotFoundException;
import com.ramRanjan.FitnessApp.exception.IdNotFoundException;

@Service
public class CustomerLibraryService {
	
	@Autowired
	private CustomerLibraryDao dao;
	@Autowired
	private CustomerLibraryDto dto;
	@Autowired
	private WorkoutPlanDao workoutDao;
	
	@Autowired
	CustomerDao customerDao;
	
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> saveCustomerLibrary(CustomerLibrary library,int customerId)
	{		
			
		Customer customer = customerDao.findCustomerById(customerId);
		if(customer!=null)
		{
		customer.setLibrary(library);
		library=dao.saveCustomerLibrary(library);

		dto.setLibraryId(library.getLibraryId());
		dto.setLibraryName(library.getLibraryName());
		
		ResponseStructure<CustomerLibraryDto> responseStructure= new ResponseStructure<>();

		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Customer Library has been Saved");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<CustomerLibraryDto>>(responseStructure,HttpStatus.CREATED); 
		}
		else
			throw new CustomerIdNotFoundException("Customer id is not present");
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
	
	
	public ResponseEntity<ResponseStructure<CustomerLibraryDto>> addLibraryWorkout(int workoutId,int customerLibraryId)
	{
		
		
		WorkoutPlan existingWorkout = workoutDao.findWorkoutbyId(workoutId);
		CustomerLibrary existingLibrary=  dao.findCustomerLibraryById(customerLibraryId);
		
		if(existingWorkout!=null)
		{
			if(existingLibrary!=null) {
			existingLibrary =dao.updateCustomerLibrary(customerLibraryId, existingLibrary);
			dto.setLibraryId(existingLibrary.getLibraryId());
			dto.setLibraryName(existingLibrary.getLibraryName());
			
	
		ResponseStructure<CustomerLibraryDto> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Customer Library has been Updated");
		responseStructure.setData(dto);
		return new ResponseEntity<ResponseStructure<CustomerLibraryDto>>(responseStructure,HttpStatus.OK); 
		}
			else
				throw new IdNotFoundException("Exercise Id Not Present");
		}
	else
		throw new IdNotFoundException("Workout Id Not Present");
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
