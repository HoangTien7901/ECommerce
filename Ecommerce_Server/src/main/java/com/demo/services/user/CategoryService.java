package com.demo.services.user;

import java.util.List;

import com.demo.models.CategoryInfor;

public interface CategoryService {

	public List<CategoryInfor> getAll();
	
	public List<CategoryInfor> getByParent(int id);
	
}
