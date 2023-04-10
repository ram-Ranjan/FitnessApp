/**
 * 
 */
package com.ramRanjan.FitnessApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ramRanjan.FitnessApp.entity.CustomerSurvey;
import com.ramRanjan.FitnessApp.repository.CustomerSurveyRepo;

/**
 * @author ram-Ranjan
 *
 */

@Repository
public class CustomerSurveyDao {
	
	@Autowired
	private CustomerSurveyRepo repo;
	
	public CustomerSurvey saveCustomerSurvey(CustomerSurvey survey)
	{
		return repo.save(survey);
	}
	
	
	
	public CustomerSurvey updateCustomerSurvey(int id,CustomerSurvey survey)
	{
		Optional<CustomerSurvey> survey2 = repo.findById(id);
		if(survey2.isPresent())
		{
			survey.setCustomer_surveyId(id);
			return repo.save(survey);
		}
		return null;
	}
	public CustomerSurvey findCustomerSurveyById(int id)
	{
		Optional<CustomerSurvey> survey = repo.findById(id);
		if(survey.isPresent())
		{
			return survey.get();
		}
		return null;

	}
	public  CustomerSurvey deleteCustomerSurveyById(int id)
	{
		Optional<CustomerSurvey> survey = repo.findById(id);
		if(survey.isPresent())
		{
			repo.delete(survey.get());
			return survey.get();
		}
		return null;
	}
	
	

}
