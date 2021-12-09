package com.ecommerce.phase3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "tbl_shoes")
@Entity
@Data
public class Shoes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String shoesCategory;

	private String shoesName;

	private Double shoesPrice;

	@Lob
	private String shoesImg;

}
