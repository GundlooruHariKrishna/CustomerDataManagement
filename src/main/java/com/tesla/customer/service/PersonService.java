package com.tesla.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesla.customer.entity.Person;
import com.tesla.customer.repository.PersonRepoImp;

@Service
public class PersonService {

	@Autowired
	PersonRepoImp repoImp;

	public Person save(Person person) {
		return repoImp.save(person);
	}

}
