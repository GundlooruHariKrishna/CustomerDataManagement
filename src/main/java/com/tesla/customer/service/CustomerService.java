package com.tesla.customer.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tesla.customer.dto.CustomerDto;
import com.tesla.customer.dto.ResponseStructure;
import com.tesla.customer.entity.CustomerEntity;
import com.tesla.customer.repository.CustomerRepositoryImplementation;

@Service
public class CustomerService {

	@Autowired
	CustomerRepositoryImplementation repository;

	public ResponseStructure<CustomerEntity> save(CustomerDto dto) {

		CustomerEntity cu = new CustomerEntity(dto);
		CustomerEntity entity = repository.saveCustomer(cu);
		ResponseStructure<CustomerEntity> res = new ResponseStructure<>();
		res.setStatusCode(HttpStatus.OK.value());
		res.setData(entity);
		res.setTimeStamp(LocalDateTime.now());
		res.setMessage("Customer data successfully saved");
		return res;

	}

	public void delete(Integer id) {
		repository.deleteCustomerById(id);
	}

	public ResponseStructure<CustomerEntity> update(CustomerDto id) {
		CustomerEntity cu = new CustomerEntity(id);
		CustomerEntity customer = repository.updateCustomer(cu);
		ResponseStructure<CustomerEntity> res = new ResponseStructure<>();
		res.setData(customer);
		res.setStatusCode(HttpStatus.ACCEPTED.value());
		res.setTimeStamp(LocalDateTime.now());
		res.setMessage(HttpStatus.ACCEPTED.name());
		return res;
	}

	public ResponseStructure<CustomerEntity> getById(Integer id) {
		CustomerEntity customerById = repository.getCustomerById(id);
		ResponseStructure<CustomerEntity> res = new ResponseStructure<>();
		res.setData(customerById);
		res.setStatusCode(HttpStatus.ACCEPTED.value());
		res.setTimeStamp(LocalDateTime.now());
		res.setMessage("successfully got data");
		return res;
	}

	public ResponseStructure<List<CustomerEntity>> getAll() {
		List<CustomerEntity> list = repository.findAllCustomers();
		ResponseStructure<List<CustomerEntity>> cu = new ResponseStructure<>();
		if (list.size() != 0) {
			cu.setStatusCode(HttpStatus.FOUND.value());
			cu.setData(list);
			cu.setTimeStamp(LocalDateTime.now());
			cu.setMessage("Entity Found");
		} else {
			cu.setStatusCode(HttpStatus.NOT_FOUND.value());
			cu.setData(null);
			cu.setTimeStamp(LocalDateTime.now());
			cu.setMessage("Entity Not Found");
		}
		return cu;
	}

	public ResponseStructure<List<CustomerEntity>> findByName(String name) {
		List<CustomerEntity> list = repository.getByName(name);
		ResponseStructure<List<CustomerEntity>> cu = new ResponseStructure<>();
		if (list.size() != 0) {
			cu.setStatusCode(HttpStatus.FOUND.value());
			cu.setData(list);
			cu.setTimeStamp(LocalDateTime.now());
			cu.setMessage("Entity Found");
		} else {
			cu.setStatusCode(HttpStatus.NOT_FOUND.value());
			cu.setData(null);
			cu.setTimeStamp(LocalDateTime.now());
			cu.setMessage("Entity Not Found");
		}
		return cu;
	}

	public List<CustomerEntity> validateCustomer(String name, String email) {
		return repository.validateCustomer(name, email);
	}
}
