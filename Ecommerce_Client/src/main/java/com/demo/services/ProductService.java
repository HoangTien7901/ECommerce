package com.demo.services;
import java.util.List;

import org.springframework.http.ResponseEntity;
import com.demo.models.ProductInfo;

public interface ProductService {
	
	public ResponseEntity<List<ProductInfo>> findByStore(int storeId);
	
	public ResponseEntity<Boolean> delete(int id);
	
	public ResponseEntity<Boolean> deleteListProduct(List<Integer> ids);
	
	public ResponseEntity<ProductInfo> create(ProductInfo product);
	
}
