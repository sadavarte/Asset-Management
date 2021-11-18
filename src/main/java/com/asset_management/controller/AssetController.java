package com.asset_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asset_management.dao.AssetRepository;
import com.asset_management.model.Asset;

@RestController
public class AssetController {
	
	@Autowired
	AssetRepository assetRepo;
	
	
	@PostMapping(path = "/addAsset")
	public void addAsset(@RequestBody Asset asset) {
		
		assetRepo.save(asset);		
	}
	
	@GetMapping(path = "/asset")
	public List<Asset> addAsset() {
		
		List<Asset> asset=assetRepo.findAll();	
		
		return asset;
	}
	
	
	
	
}
