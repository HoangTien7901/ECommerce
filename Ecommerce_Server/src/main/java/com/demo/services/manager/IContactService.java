package com.demo.services.manager;

import com.demo.entities.Contacts;

public interface IContactService {

	public Contacts getContact();
	
	public Contacts update(Contacts contact);

}
