package com.demo.controllers.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.UserId;
import com.demo.services.user.UserService;

@RestController
@RequestMapping(value = {"api/user"})
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "getuser", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserId> findAll(){
		try {
			return new ResponseEntity<UserId>(userService.getIdUser(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<UserId>(HttpStatus.BAD_REQUEST);
		}
	}
	

}
