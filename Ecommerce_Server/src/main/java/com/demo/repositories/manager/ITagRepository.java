package com.demo.repositories.manager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Tags;
import com.demo.models.CategoryInfo;
import com.demo.models.TagInfo;

public interface ITagRepository extends CrudRepository<Tags, Integer> {

	@Query("select new com.demo.models.TagInfo(id, name, status) from Tags")
	public Iterable<TagInfo> findAllInfo();
	
	@Query("select new com.demo.models.TagInfo(id, name, status) from Tags where status = true")
	public Iterable<TagInfo> findAllActiveInfo();
	
	@Query("select new com.demo.models.TagInfo(id, name, status) from Tags where id = :id")
	public TagInfo findInfoById(@Param("id") int id);
	
}
