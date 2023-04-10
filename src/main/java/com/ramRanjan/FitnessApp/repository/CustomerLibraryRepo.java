package com.ramRanjan.FitnessApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramRanjan.FitnessApp.entity.CustomerLibrary;

public interface CustomerLibraryRepo extends JpaRepository<CustomerLibrary, Integer> {

}
