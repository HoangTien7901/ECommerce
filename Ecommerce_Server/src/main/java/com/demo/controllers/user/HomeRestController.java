package com.demo.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Carts;
import com.demo.models.*;
import com.demo.repositories.user.CartsRepositories;
import com.demo.services.user.ProductService;

@RestController
@RequestMapping(value = {"api/product"})
public class HomeRestController {
	
	@Autowired
	private ProductService productService;
	
		
	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductInfo>> findAll(){
		try {
			return new ResponseEntity<List<ProductInfo>>(productService.findAllProduct(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<ProductInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductInfo> find(@PathVariable int id){
		try {
			return new ResponseEntity<ProductInfo>(productService.findProductById(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<ProductInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "topproduct", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductInfo>> topProduct(){
		try {
			return new ResponseEntity<List<ProductInfo>>(productService.topProduct(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<ProductInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "bestsell", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductInfo>> bestSell(){
		try {
			return new ResponseEntity<List<ProductInfo>>(productService.bestSell(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<ProductInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	

	
	
	

}
