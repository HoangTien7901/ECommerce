package com.demo.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Products;
import com.demo.models.ProductInfo;

@Repository("productRepositories")
public interface ProductRepositories extends CrudRepository<Products, Integer> {

	@Query("select new com.demo.models.ProductInfo(id, branchs.id, categories.id, stores.id, name, avatar, description, descriptionDetail, originalPrice, saleOffPercent, price, quantity, inventory, created, updated, isOutstanding, isBestSelling, isNew, discountPercent, discountAmount, ratingCount, ratingAverage, status, banReason, isLocked) from Products ")
	public List<ProductInfo> findAllProduct();
	
//	product detail
	@Query("select new com.demo.models.ProductInfo(id, branchs.id, categories.id, stores.id, name, avatar, description, descriptionDetail, originalPrice, saleOffPercent, price, quantity, inventory, created, updated, isOutstanding, isBestSelling, isNew, discountPercent, discountAmount, ratingCount, ratingAverage, status, banReason, isLocked) from Products where id = :id ")
	public ProductInfo findProductById(@Param("id") int id);
	
	@Query(value = "SELECT TOP 8 * FROM Products ORDER BY created DESC", nativeQuery = true)
	//@Query(value = "SELECT TOP 25 * FROM Arcust a WHERE a.arcustno <= :arcustno ORDER BY a.arcustno DESC",nativeQuery = true)
	public List<ProductInfo> topProduct();
	
	@Query("select new com.demo.models.ProductInfo(id, branchs.id, categories.id, stores.id, name, avatar, description, descriptionDetail, originalPrice, saleOffPercent, price, quantity, inventory, created, updated, isOutstanding, isBestSelling, isNew, discountPercent, discountAmount, ratingCount, ratingAverage, status, banReason, isLocked) from Products where saleOffPercent > 30")
	public List<ProductInfo> bestSell();
	
//	//search by price
//	@Query("select new com.demo.models.ProductInfo(id, branchs.id, categories.id, stores.id, name, avatar, description, descriptionDetail, originalPrice, price, quantity, inventory, created, updated, isOutstanding, isBestSelling, isNew, discountPercent, discountAmount, ratingCount, ratingAverage, status ) from Products where name like %:keyword%  ")
//	public List<ProductInfo> findPrice();
//		
//	//search by branch
//	@Query("select new com.demo.models.ProductInfo(id, branchs.id, categories.id, stores.id, name, avatar, description, descriptionDetail, originalPrice, price, quantity, inventory, created, updated, isOutstanding, isBestSelling, isNew, discountPercent, discountAmount, ratingCount, ratingAverage, status ) from Products where name like %:keyword%  ")
//	public List<ProductInfo> findBranch();
	
	//Search Controller
	@Query("select new com.demo.models.ProductInfo(id, branchs.id, categories.id, stores.id, name, avatar, description, descriptionDetail, originalPrice, saleOffPercent, price, quantity, inventory, created, updated, isOutstanding, isBestSelling, isNew, discountPercent, discountAmount, ratingCount, ratingAverage, status, banReason, isLocked) from Products where name like %:keyword% ")
	public List<ProductInfo> searchbykeyword(@Param("keyword") String keyword);
	
	@Query("select new com.demo.models.ProductInfo(id, branchs.id, categories.id, stores.id, name, avatar, description, descriptionDetail, originalPrice, saleOffPercent, price, quantity, inventory, created, updated, isOutstanding, isBestSelling, isNew, discountPercent, discountAmount, ratingCount, ratingAverage, status, banReason, isLocked) from Products where price <= :max and price >= :min")
	public List<ProductInfo> searchbyminmax(@Param("min") double min, @Param("max") double max);
	
//	//search by store ( name store )
//	@Query("select new com.demo.models.ProductInfo(id, branchs.id, categories.id, stores.id, name, avatar, description, descriptionDetail, originalPrice, price, quantity, inventory, created, updated, isOutstanding, isBestSelling, isNew, discountPercent, discountAmount, ratingCount, ratingAverage, status ) from Products where name like %:keyword%  ")
//	public List<ProductInfo> findStore();
//		
	
		
	
	
	
}
