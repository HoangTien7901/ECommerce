package com.demo.services.user;

import org.springframework.http.ResponseEntity;

import com.demo.models.UserId;

public interface UserService {

	public ResponseEntity<UserId> getIdUser();
	
	
}
