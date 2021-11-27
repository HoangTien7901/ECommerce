package com.demo.services.manager;

import java.util.Date;

import com.demo.entities.Stores;
import com.demo.models.StoreInfo;

public interface IStoreService {

	public Iterable<StoreInfo> findAllInfo();
	
	public Iterable<StoreInfo> findAllInfoActive();
	
	public StoreInfo findInfoById(int id);
	
	public Stores findById(int id);
	
	public StoreInfo update(int id, StoreInfo object);
	
	public void delete(int id);
	
	public StoreInfo add(StoreInfo object);
	
	public int toggleStatus(int id);

	public int updateBanTerm(int id, Date banTerm);
}
