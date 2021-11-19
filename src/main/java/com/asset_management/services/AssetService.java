package com.asset_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.asset_management.dao.AssetRepository;
import com.asset_management.model.Asset;

@Service
public class AssetService {

	@Autowired
	AssetRepository assetRepo;

	/**
	 * Adding asset
	 * <p>
	 * This is a addAsset method for adding new asset
	 * 
	 * </p>
	 * 
	 * @param Taking Asset object as param
	 * @return return Added asset
	 * 
	 */
	public Asset addAsset(Asset asset) {

		Asset addedAsset = assetRepo.save(asset);

		return addedAsset;

	}

	/**
	 * Getting all asset
	 * <p>
	 * This is a getAllAssets() method for getting all assets from database.
	 * 
	 * </p>
	 * 
	 * @param no param.
	 * @return returning List of all Asset.
	 * 
	 */

	public List<Asset> getAllAssets() {

		List<Asset> assets = assetRepo.findAll();
		return assets;
	}

	//
	/**
	 * Getting asset by name
	 * <p>
	 * This is a getAssetByName() method for find specific name asset.
	 * 
	 * </p>
	 * 
	 * @param String param
	 * @return returning Asset
	 * 
	 */
	public Asset getAssetByName(String name) {
		// Asset nameAsset = assetRepo.findByName(name);
		List<Asset> assets = assetRepo.findAll();
		Asset nameAsset = null;
		for (Asset asset : assets) {

			if (asset.getName().equalsIgnoreCase(name))
				nameAsset = asset;
		}

		return nameAsset;

	}

	public Asset getAssetById(Long Id) {
		Asset idAsset = assetRepo.findById(Id).orElse(null);

		return idAsset;
	}

	 
	/**
	 *  Update an asset.
	 * <p>
	 * This is a updateAsset() method update asset by using asset id.
	 * 
	 * </p>
	 * 
	 * @param Asset object and Long id
	 * @return return updated Asset
	 * 
	 */
	public Asset updateAsset(Asset asset, Long id) {

		asset.setId(id);
		Asset updatedAsset = assetRepo.save(asset);

		return updatedAsset;

	}

	  
	/**
	 *  Delete asset
	 * <p>
	 * This is a deleteAsset() method for delete asset by using asset id.
	 * But its check first that assets status if status is Assigned then 
	 * return without deleting it
	 * 
	 * </p>
	 * 
	 * @param Asset id in Long id
	 * @return return delete  Asset
	 * 
	 */
	public Asset deleteAsset(Long id) {

		Asset asset = assetRepo.findById(id).orElse(null);

		if (asset.getAssignmentStatus().equals("Assigned")) {

			return asset;
		}

		else

			assetRepo.deleteById(id);
		return asset;

	}

	 
	  
		/**
		 *  Assign Asset
		 * <p>
		 * This is a assignAsset() method for  assigning asset to employees
		 * 
		 * </p>
		 * 
		 * @param Asset id in Long id
		 * @return return String  message
		 * 
		 */
	public String assignAsset(Long assetId) {

		Asset asset = assetRepo.findById(assetId).orElse(null);

		if (asset.getAssignmentStatus().equals("Assigned"))
			return "Already Assigned";

		else
			asset.setAssignmentStatus("Assigned");

		final Asset assignAsset = assetRepo.save(asset);
		return "Assigned Sucessfully";
	}

	/**
	 *  Recover Asset
	 * <p>
	 * This is a recoveredAsset() method for  recovering asset from employees
	 * 
	 * </p>
	 * 
	 * @param Asset id in Long id
	 * @return return recovered  Asset
	 * 
	 */
	
	public Asset recoveredAsset(Long assetId) {
		Asset asset = assetRepo.findById(assetId).orElse(null);

		if (asset.getAssignmentStatus().equals("Assigned")) {

			asset.setAssignmentStatus("Recovered");

			final Asset recoveredAsset = assetRepo.save(asset);

			return recoveredAsset;
		}

		else
			return asset;
	}

}
