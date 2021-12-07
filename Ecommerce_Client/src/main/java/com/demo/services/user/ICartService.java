package com.demo.services.user;

import org.springframework.http.ResponseEntity;

import com.demo.models.CartInfo;

public interface ICartService {

	public ResponseEntity<CartInfo> findInfoById(int id);
	
	public ResponseEntity<CartInfo> create(CartInfo _object);
	
	public ResponseEntity<Void> updateStatus(int id, String status);
	
	public ResponseEntity<Void> delete(int id);
	
	public ResponseEntity<Void> deleteIfUnfinished(int id);
	
}
