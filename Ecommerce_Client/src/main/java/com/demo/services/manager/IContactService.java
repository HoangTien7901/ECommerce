package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.entities.Contacts;

public interface IContactService {

	public ResponseEntity<Contacts> getContact();

	public ResponseEntity<Void> update(Contacts contact);
}
