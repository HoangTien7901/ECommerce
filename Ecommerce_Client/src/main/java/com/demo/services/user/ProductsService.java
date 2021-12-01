package com.demo.services.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.demo.models.Products;


public interface ProductsService {
	
	public ResponseEntity<List<Products>> findAll();
	
	public ResponseEntity<Products> findProductById(int id);
	
	public ResponseEntity<List<Products>> topProduct();
	
	public ResponseEntity<List<Products>> bestSell();
	
	public ResponseEntity<com.demo.entities.Products> findById(int id);
	
	
	
}
