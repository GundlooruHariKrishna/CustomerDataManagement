package com.tesla.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tesla.customer.entity.Person;



public interface PersonRepository extends JpaRepository<Person, Integer>{

}
