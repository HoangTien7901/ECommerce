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

import com.demo.models.ProductInfo;
import com.demo.services.user.ProductService;

@RestController
@RequestMapping(value = { "api/search" })
public class SearchRestController {
	
	@Autowired 
	private ProductService productService;

	@RequestMapping(value = {"searchs/{keyword}" }, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductInfo>> SearchByKeyword(@PathVariable("keyword") String keyword) {
		try {
			return new ResponseEntity<List<ProductInfo>>(productService.SearchByKeyword(keyword), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<ProductInfo>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = {"searchs/{min}/{max}" }, method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductInfo>> SearchByMinMax(@PathVariable("min") double min, @PathVariable("max") double max) {
		try {
			return new ResponseEntity<List<ProductInfo>>(productService.SearchByMinMax(min, max), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<ProductInfo>>(HttpStatus.BAD_REQUEST);
		}
	}

}
