package com.demo.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.TagInfo;
import com.demo.models.UserInfo;
import com.demo.services.user.UserService;

@RestController
@RequestMapping(value = {"api/user"})
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "findInfoByUsername/{username}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInfo> findInfoByUsername(@PathVariable("username") String username){
		try {
			return new ResponseEntity<UserInfo>(userService.findInfoByUsername(username), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<UserInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"create"} , method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInfo> create(@RequestBody UserInfo object) {
		try {
			return new ResponseEntity<UserInfo>(userService.create(object), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<UserInfo>(HttpStatus.BAD_REQUEST);
		}
	}
}
