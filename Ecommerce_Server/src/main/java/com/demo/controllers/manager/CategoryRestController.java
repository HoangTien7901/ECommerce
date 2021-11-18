package com.demo.controllers.manager;

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

import com.demo.models.CategoryInfo;
import com.demo.services.manager.ICategoryService;

@RestController
@RequestMapping("api/manager/category")
public class CategoryRestController {
	
	@Autowired
	private ICategoryService service;
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<CategoryInfo>> findAllInfo() {
		try {
			List<CategoryInfo> items = (List<CategoryInfo>) service.findAllInfo();
			
			for (CategoryInfo item : items) {
				if (item.getParentId() != null) {
					item.setParentName(items.get(item.getParentId() - 1).getName());
				}
			}
			
			return new ResponseEntity<Iterable<CategoryInfo>>(items, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<CategoryInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findAllActive", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<CategoryInfo>> findAllActiveInfo() {
		try {
			return new ResponseEntity<Iterable<CategoryInfo>>(service.findAllActiveInfo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<CategoryInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findInfoById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryInfo> findInfoById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<CategoryInfo>(service.findInfoById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<CategoryInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"create"} , method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryInfo> create(@RequestBody CategoryInfo category) {
		try {
			return new ResponseEntity<CategoryInfo>(service.add(category), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<CategoryInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"update/{id}"} , method = RequestMethod.PUT,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryInfo> update(@PathVariable("id") int id, @RequestBody CategoryInfo category) {
		try {
			return new ResponseEntity<CategoryInfo>(service.update(id, category), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<CategoryInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"delete/{id}"} , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		try {
			service.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
