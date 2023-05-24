package com.tesla.customer.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.tesla.customer.dto.CustomerDto;
import com.tesla.customer.dto.ResponseStructure;
import com.tesla.customer.entity.CustomerEntity;

@Repository
public class CustomerRepositoryImplementation {

	@Autowired
	CustomerRepository customerRepository;

	public CustomerEntity saveCustomer(CustomerEntity entity) {
		return customerRepository.save(entity);
	}

	public CustomerEntity getCustomerById(Integer id) {
		return customerRepository.findById(id).orElse(new CustomerEntity(HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.name()));
	}

	public CustomerEntity updateCustomer(CustomerEntity customerEntity) {
		return customerRepository.save(customerEntity);
	}

	public List<CustomerEntity> findAllCustomers() {
		return customerRepository.findAll();
	}

	public CustomerEntity deleteCustomerById(Integer id) {

		CustomerEntity entity = getCustomerById(id);
		if (entity.getId() != 404) {
			customerRepository.deleteById(id);
		}
		return entity;
	}

	public List<CustomerEntity> getByName(String name) {
		return customerRepository.findByName(name);
	}

	public List<CustomerEntity> validateCustomer(String name, String email) {
		return customerRepository.validateCustomer(name, email);
	}

}
