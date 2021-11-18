package com.demo.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Banners;
import com.demo.entities.Users;
import com.demo.models.BannerInfo;
import com.demo.models.UserInfo;
import com.demo.services.manager.IBannerService;
import com.demo.services.manager.IUserService;

@RestController
@RequestMapping("api/manager/user")
public class UserRestController {
	
	@Autowired
	private IUserService service;
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<UserInfo>> findAllInfo() {
		try {
			return new ResponseEntity<Iterable<UserInfo>>(service.findAllInfo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<UserInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findInfoById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInfo> findInfoById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<UserInfo>(service.findInfoById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<UserInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> findById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Users>(service.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Users>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
