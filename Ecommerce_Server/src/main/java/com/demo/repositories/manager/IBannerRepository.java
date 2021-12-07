package com.demo.repositories.manager;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.Banners;
import com.demo.models.BannerInfo;

public interface IBannerRepository extends CrudRepository<Banners, Integer> {

	@Query("select new com.demo.models.BannerInfo(id, caption, description, link, created, updated, status, usersByCreaterId.id, usersByUpdaterId.id) from Banners")
	public Iterable<BannerInfo> findAllInfo();
	
	@Query("select new com.demo.models.BannerInfo(id, caption, description, link, created, updated, status, usersByCreaterId.id, usersByUpdaterId.id) from Banners where id = :id")
	public BannerInfo findInfoById(@Param("id") int id);
	
	@Query("select new com.demo.models.BannerInfo(id, caption, description, link, created, updated, status, usersByCreaterId.id, usersByUpdaterId.id) from Banners where status = 1")
	public BannerInfo findInfoActive();
	
	@Modifying
	@Transactional
	@Query("update Banners b set b.status = 0 where b.id <> :id")
	public int turnOffAllExcept(@Param("id") int id);
}
