/**
 * 
 */
package com.ramRanjan.FitnessApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.FitnessApp.entity.Customer;
import com.ramRanjan.FitnessApp.repository.CustomerRepo;

/**
 * @author ram-Ranjan
 *
 */

@Repository
public class CustomerDao {
	
	@Autowired
	private CustomerRepo repo;
	
	public Customer saveCustomer(Customer customer)
	{
		return repo.save(customer);
	}
	
	
	
	public Customer updateCustomer(int id,Customer customer)
	{
		Optional<Customer> customer2 = repo.findById(id);
		if(customer2.isPresent())
		{
			customer.setCustomerId(id);
			return repo.save(customer);
		}
		return null;
	}
	public Customer findCustomerById(int id)
	{
		Optional<Customer> customer = repo.findById(id);
		if(customer.isPresent())
		{
			return customer.get();
		}
		return null;

	}
	public  Customer deleteCustomerById(int id)
	{
		Optional<Customer> customer = repo.findById(id);
		if(customer.isPresent())
		{
			repo.delete(customer.get());
			return customer.get();
		}
		return null;
	}
	
	public List<Customer> getAllCustomers()
	{
		return repo.findAll();
	}



	
	

}
