package com.demo.repositories.manager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Categories;
import com.demo.models.CategoryInfo;

public interface ICategoryRepository extends CrudRepository<Categories, Integer> {

	@Query("select new com.demo.models.CategoryInfo(id, name, discountPercent, categories.id, status, level) from Categories")
	public Iterable<CategoryInfo> findAllInfo();
	
	@Query("select new com.demo.models.CategoryInfo(id, name, discountPercent, categories.id, status, level) from Categories where level <= 2")
	public Iterable<CategoryInfo> findAllForSelection();
	
	@Query("select new com.demo.models.CategoryInfo(id, name, discountPercent, categories.id, status, level) from Categories where id <> :id and level <= :level")
	public Iterable<CategoryInfo> findAllActiveExcept(@Param("id") int id, @Param("level") int level);
	
	@Query("select new com.demo.models.CategoryInfo(id, name, discountPercent, categories.id, status, level) from Categories where id = :id")
	public CategoryInfo findInfoById(@Param("id") int id);
	
}
