package com.demo.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Products;
import com.demo.models.ProductInfo;
import com.demo.repositories.user.ProductRepository;

@Service("productService")
public class ProductServiceIplm implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<ProductInfo> findByStoreId(int storeId) {
		return productRepository.findByStoreId(storeId);
	}

	@Override
	public boolean delete(int id) {
		try {
			productRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(List<Integer> ids) {
		try {
			new ProductInfo();
			productRepository.deleteAllById(ids);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Products create(Products product) {
		return productRepository.save(product);
	}

}
