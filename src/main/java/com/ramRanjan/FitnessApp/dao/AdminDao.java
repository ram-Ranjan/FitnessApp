/**
 * 
 */
package com.ramRanjan.FitnessApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.FitnessApp.entity.Admin;
import com.ramRanjan.FitnessApp.repository.AdminRepo;

/**
 * @author ram-Ranjan
 *
 */

@Repository
public class AdminDao { 
	
	@Autowired
	private AdminRepo repo;
	
	public Admin saveAdmin(Admin admin)
	{
		return repo.save(admin);
	}
	
	public Admin findAdminByEmailAndPassword(String adminEmail,String adminPassword)
	{
		return repo.findAdminByEmailAndPassword(adminEmail, adminPassword);
	}
	
	public Admin updateAdmin(int id,Admin admin)
	{
		Optional<Admin> admin2 = repo.findById(id);
		if(admin2.isPresent())
		{
			admin.setAdminId(id);
			return repo.save(admin);
		}
		return null;
	}
	public Admin findAdminById(int id)
	{
		Optional<Admin> admin = repo.findById(id);
		if(admin.isPresent())
		{
			return admin.get();
		}
		return null;

	}
	public  Admin deleteAdminById(int id)
	{
		Optional<Admin> admin = repo.findById(id);
		if(admin.isPresent())
		{
			repo.delete(admin.get());
			return admin.get();
		} 
		return null;
	}
	public Admin findbyAdminEmail(String adminEmail)
	{
		return repo.findByAdminEmail(adminEmail);
	}
	
	
	

}
