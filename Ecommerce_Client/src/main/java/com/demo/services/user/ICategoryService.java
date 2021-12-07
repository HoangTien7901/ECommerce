  package com.demo.services.user;

import org.springframework.http.ResponseEntity;

import com.demo.models.CategoryInfo;

public interface ICategoryService {

	public ResponseEntity<Iterable<CategoryInfo>> findAll();
	
	public ResponseEntity<Iterable<CategoryInfo>> findYoungestChildren();
	
}
