package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.models.StoreInfo;

public interface IStoreService {
	
	public ResponseEntity<Iterable<StoreInfo>> findAllInfo();
	
	public ResponseEntity<Iterable<StoreInfo>> findAllInfoActive();

	public ResponseEntity<StoreInfo> findInfoById(int id);
	
	public ResponseEntity<StoreInfo> create(StoreInfo object);
	
	public ResponseEntity<Void> update(StoreInfo object);
	
	public ResponseEntity<Void> delete(int id);
	
	public ResponseEntity<Void> toggleStatus(int id);

	public ResponseEntity<Void> updateBanTerm(int id, String banTerm);
}
