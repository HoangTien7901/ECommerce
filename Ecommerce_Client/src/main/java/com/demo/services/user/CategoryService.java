package com.demo.services.user;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.models.CategoryInfor;

public interface CategoryService {

	public ResponseEntity<List<CategoryInfor>> getAll();
	
	public ResponseEntity<List<CategoryInfor>> getParent(int id);
	
}
