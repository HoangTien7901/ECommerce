package com.demo.services.user;

import org.springframework.http.ResponseEntity;

public interface ISystemService {

	public ResponseEntity<com.demo.models.System> getSystem();
	
}
