package com.tesla.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tesla.customer.dto.CustomerDto;
import com.tesla.customer.dto.ResponseStructure;
import com.tesla.customer.entity.CustomerEntity;
import com.tesla.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping("/savecustomer")
	public @ResponseBody ResponseStructure<CustomerEntity> saveCustomer(@RequestBody CustomerDto dto) {
		return service.save(dto);
	}

	@GetMapping("/findById/{id}")
	public @ResponseBody ResponseStructure<CustomerEntity> findById(@PathVariable("id") Integer id) {
		return service.getById(id);
	}

	@GetMapping("/findAll")
	public @ResponseBody ResponseStructure<List<CustomerEntity>> findAll() {
		return service.getAll();
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		service.delete(id);
	}

	@GetMapping("/getByName/{name}")
	public @ResponseBody ResponseStructure<List<CustomerEntity>> getByName(@PathVariable("name") String name) {
		return service.findByName(name);
	}

	@GetMapping("/validateCustomer")
	public @ResponseBody List<CustomerEntity> validateCustomer(@RequestParam("name") String name,
			@RequestParam("email") String email) {
		return service.validateCustomer(name, email);
	}

	@PutMapping("/update")
	public @ResponseBody ResponseStructure<CustomerEntity> update(CustomerDto id) {
		return service.update(id);
	}

}
