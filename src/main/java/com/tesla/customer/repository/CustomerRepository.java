package com.tesla.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tesla.customer.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

	List<CustomerEntity> findByName(String name);
	
	
	@Query(" FROM CustomerEntity  WHERE name= :name AND email= :email")
	List<CustomerEntity> validateCustomer(@Param("name") String name, @Param("email") String email);
}
