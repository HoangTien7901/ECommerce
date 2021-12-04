package com.demo.services.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.CartProduct;
import com.demo.entities.Carts;
import com.demo.entities.Products;
import com.demo.models.CartProductInfo;
import com.demo.repositories.manager.IProductRepository;
import com.demo.repositories.user.ICartProductRepository;
import com.demo.repositories.user.ICartRepository;

@Service("cartProduct")
public class CartProductService implements ICartProductService {

	@Autowired
	private ICartProductRepository cartProductRepos;
	
	@Autowired
	private IProductRepository productRepos;
	
	@Autowired
	private ICartRepository cartRepos;

	@Override
	public Iterable<CartProductInfo> findByCartId(int cartId) {
		return cartProductRepos.findByCartId(cartId);
	}
	
	@Override
	public CartProductInfo findByCartIdAndProductId(int cartId, int productId) {
		return cartProductRepos.findByProductIdAndCartId(productId, cartId);
	}
	
	@Override
	public void deleteByCartIdAndProductId(int cartId, int productId) {
		cartProductRepos.deleteByCartIdAndProductId(cartId, productId);
	}

	@Override
	public int updateQuantity(int cartId, int productId, int quantity) {
		return cartProductRepos.updateQuantityByProductIdAndCartId(cartId, productId, quantity);
	}

	@Override
	public CartProductInfo create(CartProductInfo _object) {
		CartProductInfo info = cartProductRepos.findByProductIdAndCartId(_object.getProductId(), _object.getCartId());
		if (info != null) {
			CartProduct object = cartProductRepos.findById(info.getId()).get();
			
			object.setQuantity(object.getQuantity() + _object.getQuantity());
			
			cartProductRepos.save(object);
			
			return info;
		} else {
			CartProduct object = new CartProduct();
			
			Products product = productRepos.findById(_object.getProductId()).get();
			object.setProducts(product);
			
			Carts cart = cartRepos.findById(_object.getCartId()).get();
			object.setCarts(cart);
			
			object.setQuantity(_object.getQuantity());
			
			object = cartProductRepos.save(object);
			
			return cartProductRepos.findInfoById(object.getId());
		}
	}
	
}
