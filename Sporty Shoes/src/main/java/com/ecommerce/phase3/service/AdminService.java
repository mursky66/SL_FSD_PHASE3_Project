package com.ecommerce.phase3.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.phase3.models.Admin;
import com.ecommerce.phase3.models.Shoes;
import com.ecommerce.phase3.repository.AdminRepo;
import com.ecommerce.phase3.repository.ShoesRepo;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdminService {

	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private ShoesRepo shoesRepo;

	public boolean performAdminLogin(String email, String password) {
		try {
			Admin adminObj = adminRepo.findByEmailAndPassword(email, password);

			if (Objects.nonNull(adminObj)) {
				return true;
			}
		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());
		}
		return false;
	}

	public boolean changeAdminPassword(String email, String oldPassword, String newPassword) {
		try {
			Admin adminObj = adminRepo.findByEmail(email);

			if (Objects.nonNull(adminObj)) {

				if (!oldPassword.equals(adminObj.getPassword())) {
					return false;
				}

				adminObj.setPassword(newPassword);
				adminRepo.save(adminObj);
				return true;
			}

		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());
		}
		return false;
	}

	public Shoes saveShoes(Shoes shoes) {
		try {
			shoes = shoesRepo.save(shoes);
			return shoes;
		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());
			return null;
		}
	}

}
