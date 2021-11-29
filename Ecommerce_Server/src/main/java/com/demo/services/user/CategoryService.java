package com.demo.services.user;

import com.demo.entities.Categories;
import com.demo.models.CategoryInfo;

public interface CategoryService {
	
	public Iterable<CategoryInfo> findAll();
	
	public CategoryInfo find(int id);
	
	public Categories findById(int id);
}
