package com.demo.repositories.manager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Images;
import com.demo.models.BannerInfo;
import com.demo.models.ImageInfo;

public interface IImageRepository extends CrudRepository<Images, Integer> {

	@Query("select new com.demo.models.ImageInfo(id, banners.id, products.id, name) from Images")
	public Iterable<ImageInfo> findAllInfo();
	
	@Query("select new com.demo.models.ImageInfo(id, banners.id, products.id, name) from Images where banners.id = :id")
	public Iterable<ImageInfo> findAllInfoByBannerId(@Param("id") int id);
	
	@Query("select new com.demo.models.ImageInfo(id, banners.id, products.id, name) from Images where id = :id")
	public ImageInfo findInfoById(@Param("id") int id);
	
	public void deleteByBannersId(int id);
}
