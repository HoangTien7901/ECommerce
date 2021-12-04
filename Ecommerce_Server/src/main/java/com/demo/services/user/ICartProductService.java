package com.demo.services.user;

import com.demo.models.CartProductInfo;

public interface ICartProductService {

	public Iterable<CartProductInfo> findByCartId(int cartId);

	public CartProductInfo findByCartIdAndProductId(int cartId, int productId);
	
	public CartProductInfo create(CartProductInfo _object);
	
	public int updateQuantity(int cartId, int productId, int quantity);
	
	public void deleteByCartIdAndProductId(int cartId, int productId);
	
}
