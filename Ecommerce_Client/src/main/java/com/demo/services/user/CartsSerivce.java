package com.demo.services.user;



import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.entities.Carts;
import com.demo.models.CartsInfor;

public interface CartsSerivce {

	public ResponseEntity<List<CartsInfor>> findAll();
	
	public ResponseEntity<Carts> create(Carts carts);
	

	
}
