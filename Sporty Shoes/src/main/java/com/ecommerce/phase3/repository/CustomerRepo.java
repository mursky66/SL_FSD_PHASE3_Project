package com.ecommerce.phase3.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.phase3.models.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

	Customer findByEmailAndPassword(String email, String password);
}
