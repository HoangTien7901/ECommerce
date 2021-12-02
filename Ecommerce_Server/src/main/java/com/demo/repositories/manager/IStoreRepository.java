package com.demo.repositories.manager;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.Categories;
import com.demo.entities.Stores;
import com.demo.models.CategoryInfo;
import com.demo.models.StoreInfo;

public interface IStoreRepository extends CrudRepository<Stores, Integer> {

	@Query("select new com.demo.models.StoreInfo(id, users.id, users.username, name, phone, email, logo, created, banTerm, status) from Stores")
	public Iterable<StoreInfo> findAllInfo();
	
	@Query("select new com.demo.models.StoreInfo(id, users.id, users.username, name, phone, email, logo, created, banTerm, status) from Stores where status = 1")
	public Iterable<StoreInfo> findAllInfoActive();
	
	@Query("select name from Stores where id = :id")
	public String findNameById(@Param("id") int id);
	
	@Query("select new com.demo.models.StoreInfo(id, users.id, users.username, name, phone, email, logo, created, banTerm, status) from Stores where id = :id")
	public StoreInfo findInfoById(@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query("update Stores f set f.updated = :updated, f.status = CASE f.status WHEN true THEN false ELSE true END WHERE f.id = :id")
	public int toggleStatus(@Param("id") int id, @Param("updated") Date updated);
	
	@Modifying
	@Transactional
	@Query("update Stores f set f.banTerm = :banTerm WHERE f.id = :id")
	public int updateBanTerm(@Param("id") int id, @Param("banTerm") Date banTerm);
}
