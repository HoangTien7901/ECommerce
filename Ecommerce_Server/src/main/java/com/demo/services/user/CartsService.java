package com.demo.services.user;


import java.util.List;

import com.demo.entities.Carts;
import com.demo.models.CartsInfor;

public interface CartsService {

	public Carts save (Carts cart);
	
	public boolean delete( int id);
	
	public boolean deleteAllIdProduct(int id);
	
	public List<CartsInfor> findAllCart();
	
}
