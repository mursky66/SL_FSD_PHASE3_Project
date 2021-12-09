package com.ecommerce.phase3.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.phase3.constants.SportyShoesConstant;
import com.ecommerce.phase3.models.Shoes;
import com.ecommerce.phase3.service.AdminService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping(path = "/adminLogin")
	public String adminLoginPage() {
		log.info("adminLoginPage called");
		return "adminLogin";
	}

	@PostMapping(path = "/adminLogin")
	public String adminLogin(HttpServletRequest request, HttpServletResponse response) {
		log.info("adminLogin called");
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			log.info(email);
			log.info(password);

			boolean isLoginSuccess = adminService.performAdminLogin(email, password);
			if (isLoginSuccess) {
				return "adminHome";
			}

			request.setAttribute(SportyShoesConstant.MESSAGE, "Invalid credential");

		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());
		}
		return "adminLogin";
	}

	@GetMapping(path = "/changePassword")
	public String changePassword() {
		log.info("changePassword called");
		return "changePassword";
	}

	@PostMapping(path = "/changePassword")
	public String changePassword(HttpServletRequest request, HttpServletResponse response) {
		log.info("changePassword called");
		try {
			String email = request.getParameter("email");
			String oldpassword = request.getParameter("oldpassword");
			String newpassword = request.getParameter("newpassword");

			log.info(email);
			log.info(newpassword);

			boolean isPasswordChanged = adminService.changeAdminPassword(email, oldpassword, newpassword);
			if (isPasswordChanged) {
				request.setAttribute(SportyShoesConstant.MESSAGE, "Password has changed successfully");
				return "success";
			}

			request.setAttribute(SportyShoesConstant.MESSAGE, "Password does not changed");

		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());
		}
		return "changePassword";
	}

	@GetMapping(path = "/addShoes")
	public String addShoes() {
		log.info("addShoes called");
		return "addShoes";
	}

	@PostMapping(value = "/addShoes")
	public String addShoes(@RequestParam("shoesImge") MultipartFile multipartFile, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		log.info("addShoes called");

		OutputStream outputStream = null;
		InputStream inputStream = null;
		Shoes shoes = new Shoes();
		try {
			String fileName = multipartFile.getOriginalFilename();
			if (Objects.nonNull(fileName)) {
				String encodedString = Base64.getEncoder().encodeToString(multipartFile.getBytes());

				shoes.setShoesImg(encodedString);
			}

			String shoesCategory = request.getParameter("shoesCategory");
			String shoesName = request.getParameter("shoesName");
			String shoesPrice = request.getParameter("shoesPrice");

			shoes.setShoesCategory(shoesCategory);
			shoes.setShoesName(shoesName);

			if (Objects.nonNull(shoesPrice) && !shoesPrice.isEmpty()) {
				shoes.setShoesPrice(Double.valueOf(shoesPrice));
			}

			adminService.saveShoes(shoes);
			request.setAttribute(SportyShoesConstant.MESSAGE, "Shoes added successfully");
			return "success";

		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());
			request.setAttribute(SportyShoesConstant.MESSAGE, "Shoes not added");

		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}

		return "addShoes";

	}

}
