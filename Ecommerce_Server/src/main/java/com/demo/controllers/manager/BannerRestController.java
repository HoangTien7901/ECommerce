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
import com.demo.services.manager.IBannerService;

@RestController
@RequestMapping("api/manager/banner")
public class BannerRestController {
	
	@Autowired
	private IBannerService service;
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<BannerInfo>> findAllInfo() {
		try {
			return new ResponseEntity<Iterable<BannerInfo>>(service.findAllInfo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<BannerInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findInfoById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<BannerInfo> findInfoById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<BannerInfo>(service.findInfoById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<BannerInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"update/{id}"} , method = RequestMethod.PUT,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<BannerInfo> update(@PathVariable("id") int id, @RequestBody BannerInfo banner) {
		try {
			return new ResponseEntity<BannerInfo>(service.update(id, banner), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<BannerInfo>(HttpStatus.BAD_REQUEST);
		}
	}
}
