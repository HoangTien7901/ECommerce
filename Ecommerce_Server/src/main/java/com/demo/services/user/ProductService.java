package com.demo.services.user;

import java.util.List;

import com.demo.entities.Products;
import com.demo.models.ProductInfo;

public interface ProductService {
	
	public Iterable<ProductInfo> findByStoreId(int storeId);
	
	public boolean delete(int id);
	
	public boolean delete(List<Integer> ids);
	
	public Products create(Products product);
}
