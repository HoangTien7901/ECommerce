package com.demo.services.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Categories;
import com.demo.models.CategoryInfo;
import com.demo.repositories.user.CategoryRepository;

@Service("categoryService")
public class CategoryServiceIplm implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Iterable<CategoryInfo> findAll() {
		return categoryRepository.getList();
	}

	@Override
	public CategoryInfo find(int id) {
		return categoryRepository.find(id);
	}

	@Override
	public Categories findById(int id) {
		return categoryRepository.findById(id).get();
	}

	

}
