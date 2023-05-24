package com.tesla.customer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tesla.customer.entity.Person;


@Repository
public class PersonRepoImp {
	
	@Autowired
	PersonRepository repo;
	
	
	public Person save(Person person) {
		return repo.save(person);
	}
	
	
	

}
