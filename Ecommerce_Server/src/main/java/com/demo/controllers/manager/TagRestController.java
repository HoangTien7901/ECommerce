package com.demo.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.TagInfo;
import com.demo.services.manager.ITagService;

@RestController
@RequestMapping("api/manager/tag")
public class TagRestController {
	
	@Autowired
	private ITagService service;
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<TagInfo>> findAllInfo() {
		try {
			return new ResponseEntity<Iterable<TagInfo>>(service.findAllInfo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<TagInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findAllActive", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<TagInfo>> findAllActiveInfo() {
		try {
			return new ResponseEntity<Iterable<TagInfo>>(service.findAllActiveInfo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<TagInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findInfoById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<TagInfo> findInfoById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<TagInfo>(service.findInfoById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<TagInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"create"} , method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<TagInfo> create(@RequestBody TagInfo tag) {
		try {
			return new ResponseEntity<TagInfo>(service.add(tag), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<TagInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"update/{id}"} , method = RequestMethod.PUT,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<TagInfo> update(@PathVariable("id") int id, @RequestBody TagInfo tag) {
		try {
			return new ResponseEntity<TagInfo>(service.update(id, tag), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<TagInfo>(HttpStatus.BAD_REQUEST);
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
