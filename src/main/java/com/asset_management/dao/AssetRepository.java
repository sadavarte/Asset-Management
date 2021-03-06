package com.asset_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset_management.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {
	
	
	public Asset findByName(String name);

}
