package com.demo.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Banners;
import com.demo.models.BannerInfo;
import com.demo.models.FeedbackInfo;
import com.demo.models.ImageInfo;
import com.demo.services.manager.IBannerService;
import com.demo.services.manager.IFeedbackService;
import com.demo.services.manager.IImageService;

@RestController
@RequestMapping("api/manager/feedback")
public class FeedbackRestController {
	
	@Autowired
	private IFeedbackService service;
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<FeedbackInfo>> findAllInfo() {
		try {
			return new ResponseEntity<Iterable<FeedbackInfo>>(service.findAllInfo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<FeedbackInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findInfoById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<FeedbackInfo> findInfoById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<FeedbackInfo>(service.findInfoById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<FeedbackInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"create"} , method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<FeedbackInfo> create(@RequestBody FeedbackInfo feedback) {
		try {
			return new ResponseEntity<FeedbackInfo>(service.add(feedback), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<FeedbackInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"update/{id}"} , method = RequestMethod.PUT,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<FeedbackInfo> update(@PathVariable("id") int id, @RequestBody FeedbackInfo feedback) {
		try {
			return new ResponseEntity<FeedbackInfo>(service.update(id, feedback), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<FeedbackInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"toggleStatus/{id}"} , method = RequestMethod.PUT)
	public ResponseEntity<Void> toggleStatus(@PathVariable("id") int id) {
		try {
			service.toggleStatus(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
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
