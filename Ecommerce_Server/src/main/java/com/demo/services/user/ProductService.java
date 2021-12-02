package com.demo.services.user;


import java.util.List;

import com.demo.entities.Products;
import com.demo.models.ProductInfo;

public interface ProductService {

	public List<ProductInfo> findAllProduct();
	
	public ProductInfo findProductById(int id);
	
	public List<ProductInfo> topProduct();
	
	public List<ProductInfo> bestSell();
	
	public List<ProductInfo> SearchByKeyword (String keyword );
	
	public List<ProductInfo> SearchByMinMax (double min , double max);
	
	public Products save(Products products);
	
}
