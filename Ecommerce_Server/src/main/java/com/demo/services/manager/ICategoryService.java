package com.demo.services.manager;

import com.demo.entities.Categories;
import com.demo.models.CategoryInfo;

public interface ICategoryService {

	public Iterable<CategoryInfo> findAllInfo();
	
	public Iterable<CategoryInfo> findAllForSelection();
	
	public Iterable<CategoryInfo> findAllActiveExcept(int id, int level);
	
	public CategoryInfo findInfoById(int id);
	
	public Categories findById(int id);
	
	public CategoryInfo update(int id, CategoryInfo object);
	
	public void delete(int id);
	
	public CategoryInfo add(CategoryInfo object);

}
