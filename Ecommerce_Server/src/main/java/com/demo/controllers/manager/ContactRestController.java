package com.demo.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Contacts;
import com.demo.models.TagInfo;
import com.demo.repositories.manager.IContactRepository;
import com.demo.services.manager.IContactService;
import com.demo.services.manager.ITagService;

@RestController
@RequestMapping("api/manager/contact")
public class ContactRestController {
	
	@Autowired
	private IContactService service;
	
	@RequestMapping(value = "getContact", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contacts> findInfoById() {
		try {
			return new ResponseEntity<Contacts>(service.getContact(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Contacts>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"update"} , method = RequestMethod.PUT,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contacts> update(@RequestBody Contacts _contact) {
		try {
			Contacts contact = _contact;
			contact.setId(1);
			return new ResponseEntity<Contacts>(service.update(contact), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Contacts>(HttpStatus.BAD_REQUEST);
		}
	}
}
