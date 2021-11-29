package com.demo.services;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.models.CategoryInfo;

public interface CategoryService {
	
	public ResponseEntity<List<CategoryInfo>> findAll();
	
}
