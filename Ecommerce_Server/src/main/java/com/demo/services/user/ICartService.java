package com.demo.services.user;

import com.demo.models.CartInfo;

public interface ICartService {

	public CartInfo findInfoById(int id);

	public CartInfo create(CartInfo _object);
	
	public void delete(int id);
	
}
