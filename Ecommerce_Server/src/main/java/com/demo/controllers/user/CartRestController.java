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

import com.demo.entities.Carts;
import com.demo.models.CartsInfor;
import com.demo.repositories.user.CartsRepositories;
import com.demo.services.user.CartsService;

@RestController
@RequestMapping(value = {"api/cart"})
public class CartRestController {

	@Autowired
	private CartsService cartsService;
	
	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CartsInfor>> findAllCart(){
		try {
			return new ResponseEntity<List<CartsInfor>>(cartsService.findAllCart(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<CartsInfor>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Carts> create(@RequestBody Carts carts){
		try {
			return new ResponseEntity<Carts>(cartsService.save(carts), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Carts>(HttpStatus.BAD_REQUEST);
		}
	}	
	
}
