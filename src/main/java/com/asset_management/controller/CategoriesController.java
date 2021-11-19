package com.asset_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asset_management.dao.CategoriesRepository;
import com.asset_management.model.Asset;
import com.asset_management.model.Categories;
import com.asset_management.services.CategoryService;

@RestController
public class CategoriesController {

	@Autowired
	CategoriesRepository categoryRepo;

	@Autowired
	CategoryService catService;

	// Adding category
	@PostMapping(path = "/addcategory")
	public ResponseEntity<Categories> addCategory(@RequestBody Categories category) {
		try {

			Categories addedCat = catService.addCategory(category);
			return new ResponseEntity<Categories>(addedCat, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	// Getting all Categories
	@GetMapping(path = "/categories")
	public ResponseEntity<List<Categories>> getAssets() {

		try {

			List<Categories> allCat = catService.getCategories();

			return new ResponseEntity<List<Categories>>(allCat, HttpStatus.FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Update a Categories.
	@PutMapping("/updatecategory/{id}")
	public ResponseEntity<Categories> updateCategory(@PathVariable("id") Long categoryId,
			@RequestBody Categories categoryInfo) {

		try {

			Categories updatedCat = catService.updateCategory(categoryId, categoryInfo);

			return new ResponseEntity<Categories>(updatedCat, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

}
