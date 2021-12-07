package com.demo.services.manager;

import com.demo.entities.Products;
import com.demo.models.ProductInfo;

public interface IProductService {

	public Iterable<ProductInfo> findAllInfo();
	
	public Iterable<ProductInfo> findAllActive();
	
	public Iterable<ProductInfo> findBestSellingProducts();
	
	public Iterable<ProductInfo> findOutStandingProducts();
	
	public Iterable<ProductInfo> searchWithCategory(String keyword, double min, double max, int categoryId);
	
	public Iterable<ProductInfo> search(String keyword, double min, double max);
	
	public ProductInfo findInfoById(int id);
	
	public Products findById(int id);
	
	public ProductInfo add(ProductInfo object);
	
	public ProductInfo update(int id, ProductInfo object);
	
	public void delete(int id);
	
	public int toggleStatus(int id);
	
	public int updateBanReason(int id, String banReason);
}
