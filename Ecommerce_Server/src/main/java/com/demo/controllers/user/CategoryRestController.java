package com.demo.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.CategoryInfor;
import com.demo.services.user.CategoryService;

@RestController
@RequestMapping(value = {"api/category"})
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryInfor>> getAll(){
		try {
			return new ResponseEntity<List<CategoryInfor>>(categoryService.getAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<CategoryInfor>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "parent/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryInfor>> getByParent1(@PathVariable int id){
		try {
			return new ResponseEntity<List<CategoryInfor>>(categoryService.getByParent(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<CategoryInfor>>(HttpStatus.BAD_REQUEST);
		}
	}
	

	
}
