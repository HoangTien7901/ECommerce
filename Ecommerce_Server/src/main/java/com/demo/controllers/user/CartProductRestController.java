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

import com.demo.models.CartProductInfo;
import com.demo.services.user.ICartProductService;

@RestController
@RequestMapping(value = {"api/cartProduct"})
public class CartProductRestController {
	
	@Autowired
	private ICartProductService service;
	
	@RequestMapping(value = "findByCartId/{cartId}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<CartProductInfo>> findByCartId(@PathVariable("cartId") int cartId){
		try {
			return new ResponseEntity<Iterable<CartProductInfo>>(service.findByCartId(cartId), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Iterable<CartProductInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findByCartIdAndProductId/{cartId}/{productId}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartProductInfo> findByCartIdAndProductId(@PathVariable("cartId") int cartId, @PathVariable("productId") int productId){
		try {
			return new ResponseEntity<CartProductInfo>(service.findByCartIdAndProductId(cartId, productId), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<CartProductInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"create"} , method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartProductInfo> create(@RequestBody CartProductInfo object) {
		try {
			return new ResponseEntity<CartProductInfo>(service.create(object), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<CartProductInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"updateQuantity/{cartId}/{productId}"} , method = RequestMethod.PUT,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> create(@PathVariable("cartId") int cartId, @PathVariable("productId") int productId, @RequestBody String _quantity) {
		try {
			int quantity = Integer.parseInt(_quantity);
			int result = service.updateQuantity(cartId, productId, quantity);
			if (result == 0) {
				throw new Exception("Update cart product : no row affected");
			}
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"delete/{cartId}/{productId}"}, method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("cartId") int cartId, @PathVariable("productId") int productId) {
		try {
			service.deleteByCartIdAndProductId(cartId, productId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
