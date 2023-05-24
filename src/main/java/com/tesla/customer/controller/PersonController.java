package com.tesla.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tesla.customer.entity.Person;
import com.tesla.customer.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService service;
	
	@PostMapping("/saveperson")
	public Person save(@RequestBody Person person) {
		return service.save(person);
	}
	
}
