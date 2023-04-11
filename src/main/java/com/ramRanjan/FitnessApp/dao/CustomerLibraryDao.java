/**
 * 
 */
package com.ramRanjan.FitnessApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.FitnessApp.entity.CustomerLibrary;
import com.ramRanjan.FitnessApp.repository.CustomerLibraryRepo;

/**
 * @author ram-Ranjan
 *
 */

@Repository
public class CustomerLibraryDao {
	
	@Autowired
	private CustomerLibraryRepo repo;
	
	public CustomerLibrary saveCustomerLibrary(CustomerLibrary library)
	{
		return repo.save(library);
	}
	
	
	
	public CustomerLibrary updateCustomerLibrary(int id,CustomerLibrary library)
	{
		Optional<CustomerLibrary> library2 = repo.findById(id);
		if(library2.isPresent())
		{
			library.setLibraryId(id);
			return repo.save(library);
		}
		return null;
	}
	public CustomerLibrary findCustomerLibraryById(int id)
	{
		Optional<CustomerLibrary> library = repo.findById(id);
		if(library.isPresent())
		{
			return library.get();
		}
		return null;

	}
	public  CustomerLibrary deleteCustomerLibraryById(int id)
	{
		Optional<CustomerLibrary> library = repo.findById(id);
		if(library.isPresent())
		{
			repo.delete(library.get());
			return library.get();
		}
		return null;
	}
	
	
	

}
