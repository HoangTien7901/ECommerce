package com.demo.services.user;

import org.springframework.http.ResponseEntity;

import com.demo.models.CartProductInfo;

public interface ICartProductService {

	public ResponseEntity<Iterable<CartProductInfo>> findByCartId(int cartId);
	
	public ResponseEntity<CartProductInfo> findByCartIdAndProductId(int cartId, int productId);
	
	public ResponseEntity<CartProductInfo> create(CartProductInfo _object);
	
	public ResponseEntity<Void> updateQuantity(int cartId, int productId, int quantity);
	
	public ResponseEntity<Void> delete(int cartId, int productId);
	
}
