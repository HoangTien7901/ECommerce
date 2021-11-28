package com.demo.controllers.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.StoreInfo;
import com.demo.services.manager.IStoreService;

@RestController
@RequestMapping("api/manager/store")
public class StoreRestController {
	
	@Autowired
	private IStoreService service;
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<StoreInfo>> findAllInfo() {
		try {
			return new ResponseEntity<Iterable<StoreInfo>>(service.findAllInfo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<StoreInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findAllActive", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<StoreInfo>> findAllInfoActive() {
		try {
			return new ResponseEntity<Iterable<StoreInfo>>(service.findAllInfoActive(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<StoreInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findInfoById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<StoreInfo> findInfoById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<StoreInfo>(service.findInfoById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<StoreInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"create"} , method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<StoreInfo> create(@RequestBody StoreInfo tag) {
		try {
			return new ResponseEntity<StoreInfo>(service.add(tag), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<StoreInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"update/{id}"} , method = RequestMethod.PUT,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<StoreInfo> update(@PathVariable("id") int id, @RequestBody StoreInfo object) {
		try {
			return new ResponseEntity<StoreInfo>(service.update(id, object), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<StoreInfo>(HttpStatus.BAD_REQUEST);
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
	
	@RequestMapping(value= {"toggleStatus/{id}"} , method = RequestMethod.PUT)
	public ResponseEntity<Void> toggleStatus(@PathVariable("id") int id) {
		try {
			int result = service.toggleStatus(id);
			
			if (result == 0) {
				throw new Exception("Toggle store status failed : No row affected.");
			}
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"updateBanTerm/{id}"} , method = RequestMethod.PUT,
			consumes = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<Void> updateBanTerm(@PathVariable("id") int id, @RequestBody String _banTerm) {
		try {
			int result = 0;
			
			if (_banTerm.equals("tmp")) {
				result = service.updateBanTerm(id, null);
			} else {
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				Date banTerm = formater.parse(_banTerm);
				result = service.updateBanTerm(id, banTerm);
			}
			
			if (result == 0) {
				throw new Exception("Server - Update ban term failed : No row affected.");
			}
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
