package com.demo.services.user;

import com.demo.models.CategoryInfo;

public interface ICategoryService {

	public Iterable<CategoryInfo> findAllInfo();
	
	public Iterable<CategoryInfo> findAllByParentId(int parentId);
	
	public Iterable<CategoryInfo> findAllYoungestChildren();
}
