package com.demo.services.user;

import java.util.Date;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.constant.CartStatus;
import com.demo.entities.CartProduct;
import com.demo.entities.Carts;
import com.demo.entities.TransactionDetails;
import com.demo.entities.Users;
import com.demo.models.CartInfo;
import com.demo.models.CartProductInfo;
import com.demo.models.TransactionDetailsInfo;
import com.demo.repositories.manager.IUserRepository;
import com.demo.repositories.user.ICartProductRepository;
import com.demo.repositories.user.ICartRepository;
import com.demo.repositories.user.ITransactionDetailsRepository;
import com.demo.repositories.user.ITransactionRepository;

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

		object.setStatus(CartStatus.pending);

		object = cartRepos.save(object);

		return cartRepos.findInfoById(object.getId());
	}

	@Override
	public void delete(int id) {
		CartInfo cartInfo = cartRepos.findInfoById(id);

		// remove all product in cart
		if (cartInfo.getProductIds() != null) {
			for (Integer productId : cartInfo.getProductIds()) {
				CartProductInfo cartProductInfo = cartProductRepos.findByProductIdAndCartId(productId, id);

				CartProduct cartProduct = cartProductRepos.findById(cartProductInfo.getId()).get();

				cartProductRepos.delete(cartProduct);
			}
		}

		Carts cart = cartRepos.findById(id).get();
		cartRepos.delete(cart);
	}

	@Override
	public void deleteIfUnfinshed(int id) {
		CartInfo cartInfo = cartRepos.findInfoById(id);

		// check status
		if (cartInfo.getStatus().equals(CartStatus.pending)) {
			// remove all product in cart
			for (CartProductInfo cartProductInfo : cartProductRepos.findByCartId(id)) {
				CartProduct cartProduct = cartProductRepos.findById(cartProductInfo.getId()).get();

				cartProductRepos.delete(cartProduct);
			}
			Carts cart = cartRepos.findById(id).get();
			cartRepos.delete(cart);
		}
	}

	@Override
	public int updateStatus(int id, String _status) {
		return cartRepos.updateCartStatus(id, _status);
	}

}
