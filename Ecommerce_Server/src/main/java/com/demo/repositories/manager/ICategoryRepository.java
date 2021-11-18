package com.demo.repositories.manager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Categories;
import com.demo.models.CategoryInfo;

public interface ICategoryRepository extends CrudRepository<Categories, Integer> {

	@Query("select new com.demo.models.CategoryInfo(id, name, categories.id, status) from Categories")
	public Iterable<CategoryInfo> findAllInfo();
	
	@Query("select new com.demo.models.CategoryInfo(id, name, categories.id, status) from Categories where status = true")
	public Iterable<CategoryInfo> findAllActiveInfo();
	
	@Query("select new com.demo.models.CategoryInfo(id, name, categories.id, status) from Categories where id = :id")
	public CategoryInfo findInfoById(@Param("id") int id);
	
}
