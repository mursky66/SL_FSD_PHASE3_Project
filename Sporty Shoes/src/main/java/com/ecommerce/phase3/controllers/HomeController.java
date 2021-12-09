package com.ecommerce.phase3.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.phase3.constants.SportyShoesConstant;
import com.ecommerce.phase3.models.Shoes;
import com.ecommerce.phase3.service.ShoesService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class HomeController {

	@Autowired
	private ShoesService shoesService;

	@GetMapping(path = { "/", "/home" })
	public String homePage(HttpServletRequest request) {
		log.info("homePage called");

//		List<Shoes> allShoes = shoesService.findAll();
//		log.info("allShoes size: {}", allShoes.size());
//		request.setAttribute(SportyShoesConstant.DATA, allShoes);

		return "home";
	}

	@GetMapping(path = { "/listShoes" })
	public @ResponseBody List<Shoes> listShoes() {
		log.info("listShoes called");
		return shoesService.findAll();
	}

}
