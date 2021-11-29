package com.demo.repositories.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Categories;
import com.demo.models.CategoryInfo;

@Repository("categoryRepository")
public interface CategoryRepository extends CrudRepository<Categories, Integer> {

	@Query(value = "select new com.demo.models.CategoryInfo("
			+ "id, categories.id, discountPercent, name, status, level) "
			+ "from com.demo.entities.Categories "
			+ "WHERE id not IN (SELECT categories.id from com.demo.entities.Categories where categories.id is not null)")
	public Iterable<CategoryInfo> getList();
	
	@Query(value = "select new com.demo.models.CategoryInfo("
			+ "id, categories.id, discountPercent, name, status, level) "
			+ "from com.demo.entities.Categories "
			+ "WHERE id = :id")
	public CategoryInfo find(@Param("id") int id);
	
}
