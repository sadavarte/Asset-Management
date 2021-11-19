package com.asset_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.asset_management.dao.AssetRepository;
import com.asset_management.model.Asset;
import com.asset_management.model.Categories;
import com.asset_management.services.AssetService;
import com.fasterxml.jackson.annotation.JsonFormat;

@SpringBootTest(classes = {AssetServiceMockitoTests.class})
public class AssetServiceMockitoTests {
	
	@Mock
	AssetRepository assetRepo;
	
	@InjectMocks
	AssetService assetService;
	
	public List<Asset> myasset;
	 
	@Test
	public void test_getAllAssets() {
		List<Asset> myasset = new ArrayList<Asset>();
		 
		myasset.add(new Asset(1,"Laptop",new Date(),"Good","Available",new Categories(1,"aaaa","aaaaaaaaa")));
		myasset.add(new Asset(2,"Mobile",new Date(),"Good","Assigned",new Categories(1,"aaaa","aaaaaaaaa")));
		
		when(assetRepo.findAll()).thenReturn(myasset);
		
		assertEquals(2,assetService.getAllAssets().size());
		
	}
	
	@Test
	public void test_getAssetByName() {
		List<Asset> myasset1 = new ArrayList<Asset>();

		myasset1.add(new Asset(1,"Laptop",new Date(),"Good","Available",new Categories(1,"aaaa","aaaaaaaaa")));
		myasset1.add(new Asset(2,"Mobile",new Date(),"Good","Assigned",new Categories(1,"aaaa","aaaaaaaaa")));
		
		
		String name="Mobile";
		when(assetRepo.findAll()).thenReturn(myasset1);
		assertEquals(name,assetService.getAssetByName(name).getName());
	
	}
	
	@Test
	public void test_addAsset() {
		
		
	Asset as=new Asset(1,"Laptop",new Date(),"Good","Available",new Categories(1,"aaaa","aaaaaaaaa"));
		
		when(assetRepo.save(as)).thenReturn(as);
		
	assertEquals(as,assetService.addAsset(as));
		
	}
	
	@Test
	public void test_updateAsset() {
		
		
	Asset as=new Asset(1,"Laptop",new Date(),"Good","Available",new Categories(1,"aaaa","aaaaaaaaa"));
		long id=1;
		when(assetRepo.save(as)).thenReturn(as);
		
		assertEquals(as,assetService.updateAsset(as,id));
		
		assertEquals(id,assetService.updateAsset(as,id).getId());
	}
	
	@Test
	public void test_deleteAsset() {
		
		
	Asset as=new Asset(1,"Laptop",new Date(),"Good","Available",new Categories(1,"aaaa","aaaaaaaaa"));
		long id=1;
		 
		
		//when(assetRepo.findById(id).orElse(null)).thenReturn(as);
		
		
		 assetService.deleteAsset(id);
		
		verify(assetRepo, times(1)).deleteById(id);
		
		 
		
 	}
	
 
	
}
