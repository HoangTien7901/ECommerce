package com.demo.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.CategoryInfo;
import com.demo.repositories.user.ICategoryRepository;

@Service("userCategory")
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository repos;
	
	@Override
	public Iterable<CategoryInfo> findAllInfo() {
		return repos.findAllInfo();
	}

	@Override
	public Iterable<CategoryInfo> findAllByParentId(int parentId) {
		return repos.findAllByParentId(parentId);
	}

	@Override
	public Iterable<CategoryInfo> findAllYoungestChildren() {
		return repos.findYoungestChildrenInfo();
	}
	
}
