package com.demo.controllers.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.constant.CartStatus;
import com.demo.models.CartInfo;
import com.demo.models.CartProductInfo;
import com.demo.models.TagInfo;
import com.demo.models.UserInfo;
import com.demo.services.user.ICartProductService;
import com.demo.services.user.ICartService;

@RestController
@RequestMapping(value = {"api/cart"})
public class CartRestController {
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private ICartProductService cartProductService;
	
	@RequestMapping(value = "findInfoById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartInfo> findInfoById(@PathVariable("id") int id){
		try {
			CartInfo cart = cartService.findInfoById(id);
				
			List<Integer> productIds = new ArrayList<Integer>();
			Iterable<CartProductInfo> cartProducts = cartProductService.findByCartId(id);
			for (CartProductInfo item : cartProducts) {
				productIds.add(item.getProductId());
			}
			
			cart.setProductIds(productIds);
			
			return new ResponseEntity<CartInfo>(cart, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<CartInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"create"} , method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartInfo> create(@RequestBody CartInfo object) {
		try {
			System.out.println("Server cart user id: " + object.getUserId());
			
			for (Integer productId : object.getProductIds()) {
				System.out.println("Server cart product id: " + productId);
			}
			object.setStatus(CartStatus.pending);
			return new ResponseEntity<CartInfo>(cartService.create(object), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Server error create cart: " + e.getMessage());
			return new ResponseEntity<CartInfo>(HttpStatus.BAD_REQUEST);
		}
	}
}
