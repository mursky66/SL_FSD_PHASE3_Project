package com.ecommerce.phase3.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.phase3.constants.SportyShoesConstant;
import com.ecommerce.phase3.models.Shoes;
import com.ecommerce.phase3.service.ShoesService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class AddToCartController {

	@Autowired
	private ShoesService shoesService;

	@PostMapping(path = "/addToCart")
	public String addToCartPage(HttpServletRequest request, HttpServletResponse response) {
		log.info("addToCartPage called");
		try {

			String shoesId = request.getParameter("shoesId");
			Shoes shoes = shoesService.getShoesById(Long.valueOf(shoesId));
			request.setAttribute(SportyShoesConstant.DATA, shoes);

		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());
		}
		return "addToCart";
	}

	@PostMapping(path = "/checkout")
	public String checkout(HttpServletRequest request, HttpServletResponse response) {
		log.info("checkout called");
		try {
			request.setAttribute(SportyShoesConstant.MESSAGE, "Your order placed successfully");
		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());
		}
		return "success";
	}

//	@PostMapping(path = "/adminLogin")
//	public String adminLogin(HttpServletRequest request, HttpServletResponse response) {
//		log.info("adminLogin called");
//		try {
//			String email = request.getParameter("email");
//			String password = request.getParameter("password");
//
//			log.info(email);
//			log.info(password);
//
//			boolean isLoginSuccess = adminService.performAdminLogin(email, password);
//			if (isLoginSuccess) {
//				return "adminHome";
//			}
//
//			request.setAttribute(SportyShoesConstant.MESSAGE, "Invalid credential");
//
//		} catch (Exception ex) {
//			log.error("Error: {}", ex.getMessage());
//		}
//		return "adminLogin";
//	}
}
