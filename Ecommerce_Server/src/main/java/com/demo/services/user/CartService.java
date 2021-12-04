package com.demo.services.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.CartProduct;
import com.demo.entities.Carts;
import com.demo.entities.Users;
import com.demo.models.CartInfo;
import com.demo.repositories.manager.IUserRepository;
import com.demo.repositories.user.ICartProductRepository;
import com.demo.repositories.user.ICartRepository;

@Service("cart")
public class CartService implements ICartService {

	@Autowired
	private ICartRepository cartRepos;
	
	@Autowired
	private ICartProductRepository cartProductRepos;
	
	@Autowired
	private IUserRepository userRepos;
	
	@Override
	public CartInfo findInfoById(int id) {
		return cartRepos.findInfoById(id);
	}

	@Override
	public CartInfo create(CartInfo _object) {
		Carts object = new Carts();
		
		object.setCreated(new Date());
		
		Users user = userRepos.findById(_object.getUserId()).get();
		object.setUsers(user);
		
		object.setStatus(_object.getStatus());
		
		object = cartRepos.save(object);
		
		return cartRepos.findInfoById(object.getId());
	}

	@Override
	public void delete(int id) {
		CartInfo cartInfo = cartRepos.findInfoById(id);
		
		if (cartInfo.getProductIds() != null) {
			for (Integer productId : cartInfo.getProductIds()) {
				CartProduct cartProduct = cartProductRepos.findById(productId).get();
				
				cartProductRepos.delete(cartProduct);
			}
		}
		
		Carts cart = cartRepos.findById(id).get();
		cartRepos.delete(cart);
	}
	
}
