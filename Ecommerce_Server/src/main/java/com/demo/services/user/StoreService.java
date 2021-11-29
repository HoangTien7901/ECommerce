package com.demo.services.user;


import com.demo.entities.Stores;
import com.demo.models.StoreInfo;

public interface StoreService {
	
	public Iterable<StoreInfo> findAll();
	
	public StoreInfo find(int id);
	
	public Stores findById(int id);
	
	public Stores save(Stores store);
}
