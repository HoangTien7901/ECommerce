package com.demo.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Contacts;
import com.demo.repositories.user.ContactRepositories;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepositories contactRepositories;

	@Override
	public Contacts save(Contacts contacts) {
		return contactRepositories.save(contacts);
	}
	
	
	
}
