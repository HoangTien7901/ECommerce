package com.demo.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Contacts;
import com.demo.services.user.ContactService;

@RestController
@RequestMapping(value = {"api/contact"})
public class ContactRestController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contacts> Save(@RequestBody Contacts contacts){
		try {
			return new ResponseEntity<Contacts>(contactService.save(contacts), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Contacts>(HttpStatus.BAD_REQUEST);
		}
	}
}
