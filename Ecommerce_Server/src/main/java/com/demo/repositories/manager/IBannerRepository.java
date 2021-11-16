package com.demo.repositories.manager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Banners;
import com.demo.models.BannerInfo;

public interface IBannerRepository extends CrudRepository<Banners, Integer> {

	@Query("select new com.demo.models.BannerInfo(id, caption, description, link, created, updated, status) from Banners")
	public Iterable<BannerInfo> findAllInfo();
	
	@Query("select new com.demo.models.BannerInfo(id, caption, description, link, created, updated, status) from Banners where id = :id")
	public BannerInfo findInfoById(@Param("id") int id);
}
