package com.demo.services.user;

import org.springframework.http.ResponseEntity;

import com.demo.entities.Contacts;

public interface ContactService {

	public ResponseEntity<Void> save (Contacts contacts);
	
	
}
