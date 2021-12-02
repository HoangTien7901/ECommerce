package com.demo.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Carts;
import com.demo.entities.Products;
import com.demo.models.ProductInfo;
import com.demo.repositories.user.ProductRepositories;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepositories productRepositories;
	
	@Override
	public List<ProductInfo> findAllProduct() {
		
		return productRepositories.findAllProduct();
		
	}

	@Override
	public ProductInfo findProductById(int id) {
		
		return productRepositories.findProductById(id);
	}

	@Override
	public List<ProductInfo> topProduct() {
		return productRepositories.topProduct();
	}

	@Override
	public Products save(Products products ) {
		
		return productRepositories.save(products);
	}

	@Override
	public List<ProductInfo> bestSell() {
		return productRepositories.bestSell();
	}

	@Override
	public List<ProductInfo> SearchByKeyword(String keyword) {
		return productRepositories.searchbykeyword(keyword);
	}

	@Override
	public List<ProductInfo> SearchByMinMax(double min, double max) {
		return productRepositories.searchbyminmax(min, max);
	}
	
	

	
}
