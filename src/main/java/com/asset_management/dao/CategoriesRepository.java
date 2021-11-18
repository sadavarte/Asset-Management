package com.asset_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset_management.model.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
	
	
	public Categories findByName(String name);

}
