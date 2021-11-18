package com.asset_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Service;
 
 
import com.asset_management.dao.AssetRepository;
import com.asset_management.model.Asset;
 
@Service
public class AssetService {

	@Autowired
	AssetRepository assetRepo;
	
	 

	// Adding asset
	public void addAsset(Asset asset) {

		assetRepo.save(asset);

	}

	// Getting all asset
	public List<Asset> getAllAssets() {

		List<Asset> asset = assetRepo.findAll();
		return asset;
	}

	// Getting asset by name
	public Asset getAssetByName(String name) {
		return assetRepo.findByName(name);

	}

	// Update an asset.
	public Asset updateAsset(Asset asset, Long id) {

		asset.setId(id);
		assetRepo.save(asset);
		 
		return asset;

	}
	
	//Delete asset
	public void deleteAsset(Long id) {

		assetRepo.deleteById(id); 

	}

}
