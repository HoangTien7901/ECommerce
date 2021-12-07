package com.demo.repositories.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Categories;
import com.demo.models.CategoryInfo;

@Repository("userCategoryRepos")
public interface ICategoryRepository extends CrudRepository<Categories, Integer> {

	@Query("select new com.demo.models.CategoryInfo(id, name, categories.id, status) from Categories where categories.id is null")
	public Iterable<CategoryInfo> findAllInfo();
	
	@Query("select new com.demo.models.CategoryInfo(id, name, categories.id, status) from Categories where categories.id = :parentId")
	public Iterable<CategoryInfo> findAllByParentId(@Param("parentId") int parentId);

	@Query("select new com.demo.models.CategoryInfo(id, name, discountPercent, categories.id, status, level) from Categories where level = 3")
	public Iterable<CategoryInfo> findYoungestChildrenInfo();
}
