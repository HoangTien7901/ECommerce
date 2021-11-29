package com.demo.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.CategoryInfo;
import com.demo.services.user.*;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<CategoryInfo>> findAll() {
		try {
			return new ResponseEntity<Iterable<CategoryInfo>>(categoryService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Iterable<CategoryInfo>>(HttpStatus.BAD_REQUEST);
		}
	}	
	
	@RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryInfo> find(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<CategoryInfo>(categoryService.find(id), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<CategoryInfo>(HttpStatus.BAD_REQUEST);
		}
	}	

}
