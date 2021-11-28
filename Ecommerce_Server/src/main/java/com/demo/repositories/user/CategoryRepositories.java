package com.demo.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Categories;
import com.demo.models.CategoryInfor;

@Repository("categoryRepositories")
public interface CategoryRepositories extends CrudRepository<Categories, Integer> {
	
	@Query("select new com.demo.models.CategoryInfor(id, categories.id, name, discountPercent, status, level) from Categories")
	public List<CategoryInfor> getAll();
	
	@Query("select new com.demo.models.CategoryInfor(id, categories.id, name, discountPercent, status, level) from Categories where parent_id = :id")
	public List<CategoryInfor> getByParent(@Param("id") int id);

}
