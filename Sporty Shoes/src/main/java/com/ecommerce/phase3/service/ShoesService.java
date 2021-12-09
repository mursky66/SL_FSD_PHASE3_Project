package com.ecommerce.phase3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.phase3.models.Shoes;
import com.ecommerce.phase3.repository.ShoesRepo;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ShoesService {

	@Autowired
	private ShoesRepo shoesRepo;

	public List<Shoes> findAll() {
		try {
			Iterable<Shoes> shoes = shoesRepo.findAll();
			Iterator<Shoes> shoesItr = shoes.iterator();
			List<Shoes> allShoes = new ArrayList<Shoes>();
			while (shoesItr.hasNext()) {
				Shoes s = shoesItr.next();
				allShoes.add(s);
			}
			return allShoes;
		} catch (Exception ex) {
			log.error("Error: {}", ex.getMessage());
		}
		return null;
	}

	public Shoes getShoesById(Long shoesId) {
		Optional<Shoes> shoesOpt = shoesRepo.findById(shoesId);
		return shoesOpt.orElse(null);
	}
}
