package com.demo.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Images;
import com.demo.models.ImagesInfor;

@Repository("imageRepositories")
public interface ImageRepositories extends CrudRepository<Images, Integer> {
	
	@Query("select new com.demo.models.ImagesInfor(id, banners.id, products.id, name) from Images")
	public List<ImagesInfor> findAllImages();
	
	@Query("select new com.demo.models.ImagesInfor(id, banners.id, products.id, name) from Images where products.id = :id ")
	public List<ImagesInfor> findImageByIdProduct(@Param("id") int id);
	
	
	
}
