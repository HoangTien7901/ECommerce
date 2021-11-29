package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.models.UserInfo;

public interface IUserService {
	
	public ResponseEntity<Iterable<UserInfo>> findAllInfo();
	
	public ResponseEntity<Iterable<UserInfo>> findAllInfoActive();

	public ResponseEntity<UserInfo> findInfoById(int id);
	
	public ResponseEntity<UserInfo> create(UserInfo object);
	
	public ResponseEntity<Void> update(UserInfo object);
	
	public ResponseEntity<Void> delete(int id);
	
	public ResponseEntity<Void> toggleStatus(int id);

	public ResponseEntity<Void> updateBanTerm(int id, String banTerm);
}
