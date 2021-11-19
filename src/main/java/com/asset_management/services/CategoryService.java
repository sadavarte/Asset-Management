package com.asset_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.asset_management.dao.CategoriesRepository;
import com.asset_management.model.Categories;

@Service
public class CategoryService {

	@Autowired
	CategoriesRepository categoryRepo;

	// Adding category

	public Categories addCategory(Categories category) {

		Categories addedCategory = categoryRepo.save(category);

		return addedCategory;

	}

	// Getting all Categories

	public List<Categories> getCategories() {

		List<Categories> cat = categoryRepo.findAll();

		return cat;
	}

	// Update a Categories.

	public Categories updateCategory(Long categoryId, Categories category) {

		category.setId(categoryId);

		Categories updatecategory = categoryRepo.save(category);

		return updatecategory;
	}
}
