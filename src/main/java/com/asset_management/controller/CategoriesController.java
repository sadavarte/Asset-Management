package com.asset_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asset_management.dao.CategoriesRepository;
import com.asset_management.model.Categories;

@RestController
public class CategoriesController {
	
	@Autowired
	CategoriesRepository categoryRepo;
	
	
	@GetMapping(path = "/categories")
	public List<Categories> getCategories() {
		
		List<Categories> cat= categoryRepo.findAll(); 	
		
		return cat;
	}
	
	
}
