package com.asset_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asset_management.model.Asset;
import com.asset_management.model.Categories;
import com.asset_management.services.AssetService;

@RestController
public class AssetController {

	@Autowired
	AssetService assetService;

	// Adding asset
	@PostMapping(path = "/addAsset")
	public ResponseEntity<Asset> addAsset(@RequestBody Asset asset) {
		try {
			Asset addedAsset = assetService.addAsset(asset);
			return new ResponseEntity<Asset>(addedAsset, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	// Getting all asset
	@GetMapping(path = "/assets")
	public ResponseEntity<List<Asset>> getAssets() {
		try {
			List<Asset> allAssets = assetService.getAllAssets();
			return new ResponseEntity<List<Asset>>(allAssets, HttpStatus.FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Search assets based on name
	@GetMapping("/asset/{name}")
	public ResponseEntity<Asset> getAssetByName(@PathVariable("name") String name) {
		try {
			Asset asset = assetService.getAssetByName(name);
			return new ResponseEntity<Asset>(asset, HttpStatus.FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Update an asset.
	@PutMapping("/updateAsset/{id}")
	public ResponseEntity<Asset> updateAsset(@PathVariable("id") Long AssetId, @RequestBody Asset assetInfo) {
		try {
			Asset updatedAsset = assetService.updateAsset(assetInfo, AssetId);
			return new ResponseEntity<Asset>(updatedAsset, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	// Delete an asset.
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Asset> deleteAsset(@PathVariable("id") Long id) {

		Asset deletedAsset = null;
		try {
			 
			deletedAsset = assetService.deleteAsset(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Asset>(deletedAsset, HttpStatus.OK);
	}

	// Assign an asset to an employee

	@PutMapping("/assign/{id}")
	public ResponseEntity<String> assignAsset(@PathVariable("id") Long AssetId) {
		try {
			String assignedAsset = assetService.assignAsset(AssetId);
			return new ResponseEntity<String>(assignedAsset, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Recover an asset from an employee

	@PutMapping("/recover/{id}")
	public ResponseEntity<Asset> recoverAsset(@PathVariable("id") Long Id) {
		try {
			Asset recoveredAsset = assetService.recoveredAsset(Id);
			
			return new ResponseEntity<Asset>(recoveredAsset, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
