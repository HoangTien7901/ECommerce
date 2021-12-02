package com.demo.services.user;

import org.springframework.http.ResponseEntity;

import com.demo.models.UserInfo;

public interface IUserService {
	
	public ResponseEntity<UserInfo> findInfoByUsername(String username);
	
	public ResponseEntity<UserInfo> create(UserInfo object);
	
	public ResponseEntity<Void> update(UserInfo object);
	
}
