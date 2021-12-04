package com.demo.repositories.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.CartProduct;
import com.demo.models.CartProductInfo;

public interface ICartProductRepository extends CrudRepository<CartProduct, Integer> {
	
	@Query("select new com.demo.models.CartProductInfo(id, carts.id, products.id, quantity) from CartProduct where carts.id = :cartId")
	public Iterable<CartProductInfo> findByCartId(@Param("cartId") int cartId);

	@Query("select new com.demo.models.CartProductInfo(id, carts.id, products.id, quantity) from CartProduct where id = :id")
	public CartProductInfo findInfoById(@Param("id") int id);
	
	@Query("select new com.demo.models.CartProductInfo(id, carts.id, products.id, quantity) from CartProduct where carts.id = :cartId and products.id = :productId")
	public CartProductInfo findByProductIdAndCartId(@Param("productId") int productId, @Param("cartId") int cartId);
	
	@Modifying
	@Transactional
	@Query("update CartProduct set quantity = :quantity where carts.id = :cartId and products.id = :productId")
	public int updateQuantityByProductIdAndCartId(@Param("cartId") int cartId, @Param("productId") int productId, @Param("quantity") int quantity);

	@Modifying
	@Transactional
	@Query("delete from CartProduct where carts.id = :cartId and products.id = :productId")
	public void deleteByCartIdAndProductId(@Param("cartId") int cartId, @Param("productId") int productId);
}
