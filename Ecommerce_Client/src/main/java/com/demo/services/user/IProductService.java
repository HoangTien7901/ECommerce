package com.demo.services.user;

import org.springframework.http.ResponseEntity;

import com.demo.models.ProductInfo;

public interface IProductService {
	
	public ResponseEntity<Iterable<ProductInfo>> findAllInfo();
	
	public ResponseEntity<Iterable<ProductInfo>> findBestSelling();
	
	public ResponseEntity<Iterable<ProductInfo>> findOutStanding();

	public ResponseEntity<ProductInfo> findInfoById(int id);
	
	public ResponseEntity<Void> update(ProductInfo object);
	
}
