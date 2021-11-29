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

import com.demo.models.NotificationInfo;
import com.demo.services.manager.INotificationService;

@RestController
@RequestMapping("api/manager/notification")
public class NotificationRestController {
	
	@Autowired
	private INotificationService service;
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<NotificationInfo>> findAllInfo() {
		try {
			return new ResponseEntity<Iterable<NotificationInfo>>(service.findAllInfo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<NotificationInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findInfoById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationInfo> findInfoUserById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<NotificationInfo>(service.findInfoById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<NotificationInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"create"} , method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationInfo> create(@RequestBody NotificationInfo feedback) {
		try {
			return new ResponseEntity<NotificationInfo>(service.add(feedback), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<NotificationInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"update/{id}"} , method = RequestMethod.PUT,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationInfo> update(@PathVariable("id") int id, @RequestBody NotificationInfo feedback) {
		try {
			return new ResponseEntity<NotificationInfo>(service.update(id, feedback), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<NotificationInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"delete/{id}"} , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		try {
			service.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
