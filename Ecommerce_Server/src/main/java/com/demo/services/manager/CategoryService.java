package com.demo.services.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Banners;
import com.demo.entities.Categories;
import com.demo.entities.Images;
import com.demo.models.CategoryInfo;
import com.demo.models.ImageInfo;
import com.demo.repositories.manager.IBannerRepository;
import com.demo.repositories.manager.ICategoryRepository;
import com.demo.repositories.manager.IImageRepository;

@Service("category")
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository repos;

	@Override
	public Iterable<CategoryInfo> findAllInfo() {
		return repos.findAllInfo();
	}

	@Override
	public Iterable<CategoryInfo> findAllActiveInfo() {
		return repos.findAllActiveInfo();
	}

	@Override
	public Iterable<CategoryInfo> findAllActiveExcept(int id, int level) {
		return repos.findAllActiveExcept(id, level);
	}

	@Override
	public CategoryInfo findInfoById(int id) {
		return repos.findInfoById(id);
	}

	@Override
	public Categories findById(int id) {
		return repos.findById(id).get();
	}

	@Override
	public CategoryInfo update(int id, CategoryInfo object) {

		Categories categories = repos.findById(id).get();

		if (object.getParentId() != 0) {
			Categories parent = repos.findById(object.getParentId()).get();
			categories.setCategories(parent);
			categories.setLevel(parent.getLevel() + 1);
		} else {
			categories.setCategories(null);
			categories.setLevel(1);
		}

		categories.setName(object.getName());
		categories.setDiscountPercent(object.getDiscount_percent());
		categories.setStatus(object.isStatus());

		categories = repos.save(categories);

		return repos.findInfoById(id);
	}

	@Override
	public void delete(int id) {
		repos.delete(repos.findById(id).get());
	}

	@Override
	public CategoryInfo add(CategoryInfo object) {

		Categories categories = new Categories();

		if (object.getParentId() != 0) {
			Categories parent = repos.findById(object.getParentId()).get();
			categories.setCategories(parent);
			categories.setLevel(parent.getLevel() + 1);
		} else {
			categories.setCategories(null);
			categories.setLevel(1);
		}  

		categories.setName(object.getName());
		categories.setDiscountPercent(object.getDiscount_percent());
		categories.setStatus(object.isStatus());

		categories = repos.save(categories);

		return repos.findInfoById(categories.getId());
	}
}
