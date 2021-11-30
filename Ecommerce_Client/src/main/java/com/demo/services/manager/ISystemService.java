package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

public interface ISystemService {

	public ResponseEntity<com.demo.models.System> getSystem();

	public ResponseEntity<Void> update(com.demo.models.System object);
	
}
