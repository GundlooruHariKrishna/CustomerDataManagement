package com.tesla.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tesla.customer.entity.BankAccount;

public interface BankRepository extends JpaRepository<BankAccount, Integer>{

}
