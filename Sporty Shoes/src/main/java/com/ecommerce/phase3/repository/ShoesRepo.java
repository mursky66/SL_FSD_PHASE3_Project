package com.ecommerce.phase3.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.phase3.models.Shoes;

public interface ShoesRepo extends CrudRepository<Shoes, Long> {
}
