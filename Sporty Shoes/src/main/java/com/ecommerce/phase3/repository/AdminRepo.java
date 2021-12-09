package com.ecommerce.phase3.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.phase3.models.Admin;

public interface AdminRepo extends CrudRepository<Admin, Long> {

	Admin findByEmailAndPassword(String email, String password);
	
	Admin findByEmail(String email);
	

}
