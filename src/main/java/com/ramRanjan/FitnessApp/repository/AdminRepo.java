package com.ramRanjan.FitnessApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ramRanjan.FitnessApp.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	public Admin findByAdminEmail(String adminEmail);
	
	@Query("Select a from Admin a where a.adminEmail = :email and a.adminPassword = :password")
	public Admin findAdminByEmailAndPassword(@Param ("email")String email, @Param("password")String password);
	
}
