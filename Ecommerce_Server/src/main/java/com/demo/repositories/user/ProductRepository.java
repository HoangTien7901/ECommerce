package com.demo.repositories.user;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Products;
import com.demo.models.ProductInfo;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Products, Integer> {

	@Query(value = "select new com.demo.models.ProductInfo("
			+ "id, branchs.id, branchs.name, categories.id, categories.name, stores.id, "
			+ "stores.name, name, avatar, description, descriptionDetail, originalPrice, saleOffPercent, price, quantity, inventory, "
			+ "created, updated, isOutstanding, isBestSelling, isNew, discountPercent, "
			+ "discountAmount, ratingCount, ratingAverage, status, banReason, isLocked) "
			+ "from com.demo.entities.Products WHERE stores.id = :storeId")
	public Iterable<ProductInfo> findByStoreId(@Param("storeId") int storeId);
}
