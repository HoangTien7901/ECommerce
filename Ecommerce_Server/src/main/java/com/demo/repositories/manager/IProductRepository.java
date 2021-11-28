package com.demo.repositories.manager;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.Products;
import com.demo.models.ProductInfo;

public interface IProductRepository extends CrudRepository<Products, Integer> {

	@Query("select new com.demo.models.ProductInfo(id, branchs.id, branchs.name, categories.id, categories.name, stores.id, stores.name, name, avatar, description, descriptionDetail, originalPrice, saleOffPercent, price, quantity, inventory, created, updated, isOutstanding, isBestSelling, isNew, discountPercent, discountAmount, ratingCount, ratingAverage, status, banReason, isLocked) from Products ")
	public Iterable<ProductInfo> findAllInfo();
	
	@Query("select new com.demo.models.ProductInfo(id, branchs.id, branchs.name, categories.id, categories.name, stores.id, stores.name, name, avatar, description, descriptionDetail, originalPrice, saleOffPercent, price, quantity, inventory, created, updated, isOutstanding, isBestSelling, isNew, discountPercent, discountAmount, ratingCount, ratingAverage, status, banReason, isLocked) from Products where id = :id")
	public ProductInfo findInfoById(@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query("update Products f set f.updated = :updated, f.status = CASE f.status WHEN true THEN false ELSE true END WHERE f.id = :id")
	public int toggleStatus(@Param("id") int id, @Param("updated") Date updated);
	
	@Modifying
	@Transactional
	@Query("update Products f set f.banReason = :banReason WHERE f.id = :id")
	public int updateBanReason(@Param("id") int id, @Param("banReason") String banReason);
}
