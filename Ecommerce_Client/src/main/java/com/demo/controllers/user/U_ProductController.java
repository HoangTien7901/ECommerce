package com.demo.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.ProductInfo;
import com.demo.services.manager.IProductService;

@Controller
@RequestMapping(value = {"user/product" })
public class U_ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping(value = { "findInfoById/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<ProductInfo> findProductByInfo(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<ProductInfo>(productService.findInfoById(id).getBody(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ProductInfo>(HttpStatus.BAD_REQUEST);
		}
	}
}