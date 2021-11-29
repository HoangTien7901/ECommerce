package com.demo.apis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Stores;
import com.demo.models.StoreInfo;
import com.demo.services.user.*;

@RestController
@RequestMapping("/api/store")
public class StoreRestController {

	@Autowired
	private StoreService storeService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<StoreInfo> find(@RequestParam("id") int id) {
		try {
			return new ResponseEntity<StoreInfo>(storeService.find(id), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<StoreInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value = "create", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Stores> create(@RequestBody StoreInfo info) {
		try {
			Stores store = new Stores();
			store.setAddress(info.getAddress());
			store.setCreated(info.getCreated());
			store.setEmail(info.getEmail());
			store.setExpiry(info.getExpiry());
			store.setLogo(info.getLogo());
			store.setName(info.getName());
			store.setPhone(info.getPhone());
			store.setUsers(userService.findById(info.getUserId()));
			store.setStatus(info.isStatus());			
			return new ResponseEntity<Stores>(storeService.save(store), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Stores>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Stores> update(@RequestBody StoreInfo info) {
		try {
			Stores store = storeService.findById(info.getId());
			store.setAddress(info.getAddress());
			store.setCreated(info.getCreated());
			store.setEmail(info.getEmail());
			store.setExpiry(info.getExpiry());
			store.setLogo(info.getLogo());
			store.setName(info.getName());
			store.setPhone(info.getPhone());
			store.setStatus(info.isStatus());						
			return new ResponseEntity<Stores>(storeService.save(store), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Stores>(HttpStatus.BAD_REQUEST);
		}
	}

}
