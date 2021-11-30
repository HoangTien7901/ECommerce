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
import com.demo.models.ImageInfo;
import com.demo.services.manager.IBannerService;
import com.demo.services.manager.IImageService;

@RestController
@RequestMapping("api/manager/image")
public class ImageRestController {
	
	@Autowired
	private IImageService service;
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<ImageInfo>> findAllInfo() {
		try {
			return new ResponseEntity<Iterable<ImageInfo>>(service.findAllInfo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<ImageInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findAllByBannerId/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<ImageInfo>> findAllInfoByBannerId(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Iterable<ImageInfo>>(service.findAllInfoByBannerId(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<ImageInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findInfoById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImageInfo> findInfoById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<ImageInfo>(service.findInfoById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ImageInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"create"} , method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImageInfo> create(@RequestBody ImageInfo image) {
		try {
			return new ResponseEntity<ImageInfo>(service.add(image), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ImageInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"update/{id}"} , method = RequestMethod.PUT,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImageInfo> update(@PathVariable("id") int id, @RequestBody ImageInfo image) {
		try {
			return new ResponseEntity<ImageInfo>(service.update(id, image), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ImageInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"deleteByBannerId/{id}"} , method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteByBannerId(@PathVariable("id") int id) {
		try {
			service.deleteAllByBannerId(id);
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
