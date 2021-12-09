package com.ecommerce.phase3.controllers;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.phase3.constants.SportyShoesConstant;
import com.ecommerce.phase3.models.Customer;
import com.ecommerce.phase3.service.CustomerService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(path = { "/customer-signup" })
	public String customerSignUpPage() {
		log.info("customerSignUpPage called");

		return "customerSignup";
	}

	@PostMapping(value = "/customer-signup")
	public String addCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.info("addCustomer called");

		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String password = request.getParameter("password");
			String mobile = request.getParameter("mobile");

			Customer cust = new Customer();
			cust.setName(name);
			cust.setEmail(email);
			cust.setGender(gender);
			cust.setPassword(password);
			cust.setMobile(mobile);

			Customer savedCust = customerService.saveCustomer(cust);

			if (Objects.nonNull(savedCust)) {
				request.setAttribute(SportyShoesConstant.MESSAGE, "Signup successfully");
				return "success";
			}

		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());

		} finally {
		}
		request.setAttribute(SportyShoesConstant.MESSAGE, "Customer signup failed");

		return "customerSignup";

	}
	
	@GetMapping(path = "/customer-login")
	public String customerLoginPage() {
		log.info("customerLoginPage called");
		return "customerLogin";
	}

	@PostMapping(path = "/customer-login")
	public String customerLogin(HttpServletRequest request, HttpServletResponse response) {
		log.info("customerLogin called");
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			log.info(email);
			log.info(password);

			boolean isLoginSuccess = customerService.performAdminLogin(email, password);
			if (isLoginSuccess) {
				return "addToCart";
			}

			request.setAttribute(SportyShoesConstant.MESSAGE, "Invalid credential");

		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());
		}
		return "adminLogin";
	}

}
