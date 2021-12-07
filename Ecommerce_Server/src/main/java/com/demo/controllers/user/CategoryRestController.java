package com.demo.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.CategoryInfo;
import com.demo.services.user.ICategoryService;

@RestController
@RequestMapping(value = {"api/category"})
public class CategoryRestController {
	
	@Autowired
	private ICategoryService service;
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<CategoryInfo>> findAllInfo(){
		try {
			Iterable<CategoryInfo> result = service.findAllInfo();
			
			for (CategoryInfo item1 : result) {
				List<CategoryInfo> childen = (List<CategoryInfo>) service.findAllByParentId(item1.getId());
				
				for (CategoryInfo item2 : childen) {
					List<CategoryInfo> childenOfChildren = (List<CategoryInfo>) service.findAllByParentId(item2.getId());
					
					item2.setChildCategories(childenOfChildren);
				}
				
				item1.setChildCategories(childen);
			}
			
			return new ResponseEntity<Iterable<CategoryInfo>>(result, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Iterable<CategoryInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findYoungestChildren", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<CategoryInfo>> findYoungestChilren(){
		try {
			return new ResponseEntity<Iterable<CategoryInfo>>(service.findAllYoungestChildren(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Iterable<CategoryInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
	
	
