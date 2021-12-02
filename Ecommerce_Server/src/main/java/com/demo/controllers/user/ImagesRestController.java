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


import com.demo.models.ImagesInfor;

import com.demo.services.user.ImageService;

@RestController
@RequestMapping(value = {"api/image"})
public class ImagesRestController {
	
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value = "findAllImages", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ImagesInfor>> findAllImages(){
		try {
			return new ResponseEntity<List<ImagesInfor>>(imageService.findAllImages(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<ImagesInfor>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ImagesInfor>> find(@PathVariable int id){
		try {
			return new ResponseEntity<List<ImagesInfor>>(imageService.imageByIdProduct(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<ImagesInfor>>(HttpStatus.BAD_REQUEST);
		}
	}
	

}
