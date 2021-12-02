package com.demo.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.System;
import com.demo.services.manager.ISystemService;

@RestController
@RequestMapping(value = {"api/manager/system", "api/system"})
public class SystemRestController {
	
	@Autowired
	private ISystemService service;
	
	@RequestMapping(value = "getSystem", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<System> findAllInfo() {
		try {
			return new ResponseEntity<System>(service.getSystem(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<System>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"update"} , method = RequestMethod.PUT,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<System> update(@RequestBody System system) {
		try {
			System object = system;
			
			if (object.getEmailPassword().isEmpty()) {
				object.setEmailPassword(service.getSystem().getEmailPassword());
			}
			
			return new ResponseEntity<System>(service.update(system), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<System>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
