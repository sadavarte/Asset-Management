package com.asset_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 
import com.asset_management.model.Asset;
import com.asset_management.services.AssetService;

@RestController
public class AssetController {

	 
	@Autowired
	AssetService assetService;

	// Adding asset
	@PostMapping(path = "/addAsset")
	public void addAsset(@RequestBody Asset asset) {

		assetService.addAsset(asset);

	}

	// Getting all asset
	@GetMapping(path = "/assets")
	public List<Asset> getAssets() {

		return assetService.getAllAssets();
	}

	// Search assets based on name
	@GetMapping("/assets/{name}")
	public Asset getAssetByName(@PathVariable String name) {
		
		return assetService.getAssetByName(name);
			
	}

	// Update an asset.
	@PutMapping("/updateAsset/{id}")
	public  Asset updateAsset(@PathVariable 
	Long AssetId, @RequestBody Asset assetInfo){
		
		return assetService.updateAsset(assetInfo, AssetId);
	}
			 
	//Delete an asset.
	@DeleteMapping("/delete/{id}")
	 public void deleteAsset(@PathVariable Long id) {
	         
			 assetService.deleteAsset(id);
	        }
	
}
