package com.ecommerce.phase3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class SportyShooesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShooesApplication.class, args);
		log.info("SportyShooesApplication Started");
	}

}
