package com.ecommerce.phase3.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.phase3.models.Customer;
import com.ecommerce.phase3.repository.CustomerRepo;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CustomerService {

	@Autowired
	private CustomerRepo custRepo;

	public Customer saveCustomer(Customer c) {
		try {
			return custRepo.save(c);
		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());
		}
		return null;
	}

	public boolean performAdminLogin(String email, String password) {
		try {
			Customer customerObj = custRepo.findByEmailAndPassword(email, password);

			if (Objects.nonNull(customerObj)) {
				return true;
			}
		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());
		}
		return false;
	}

}
