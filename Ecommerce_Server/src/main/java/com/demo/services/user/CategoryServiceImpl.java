package com.demo.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.CategoryInfor;
import com.demo.repositories.user.CategoryRepositories;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepositories categoryRepositories;
	
	@Override
	public List<CategoryInfor> getAll() {
		return categoryRepositories.getAll();
	}

	@Override
	public List<CategoryInfor> getByParent(int id) {
		return categoryRepositories.getByParent(id);
	}

	
}
