package com.demo.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Carts;
import com.demo.models.CartsInfor;
import com.demo.repositories.user.CartsRepositories;

@Service("cartsService")
public class CartsServiceImpl implements CartsService {

	@Autowired
	private CartsRepositories cartsRepositories;
	
	@Override
	public Carts save(Carts cart) {
		return cartsRepositories.save(cart);
	}

	@Override
	public boolean delete(int id) {
		try {
			cartsRepositories.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteAllIdProduct(int id) {
		try {
			cartsRepositories.deleteByIdProduct(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<CartsInfor> findAllCart() {
		return cartsRepositories.findAllCart();
	}

	



}
