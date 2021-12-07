package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.models.ProductInfo;

public interface IProductService {
	
	public ResponseEntity<Iterable<ProductInfo>> findAllInfo();

	public ResponseEntity<ProductInfo> findInfoById(int id);
	
	public ResponseEntity<Void> update(ProductInfo object);
	
	public ResponseEntity<Void> delete(int id);
	
	public ResponseEntity<Void> toggleStatus(int id);
	
	public ResponseEntity<Void> updateBanReason(int id, String banReason);

	public ResponseEntity<ProductInfo> create(ProductInfo item);
}
