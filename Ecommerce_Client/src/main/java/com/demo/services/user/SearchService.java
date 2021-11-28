package com.demo.services.user;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.models.Products;

public interface SearchService {

	public ResponseEntity<List<Products>> searchByKeyword( String product);
	
	public ResponseEntity<List<Products>> searchbyMinMax( double min, double max);
	
	
}
