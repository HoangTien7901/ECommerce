package com.demo.services.user;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.models.Images;

public interface ImagesService {
	
	public ResponseEntity<List<Images>> imageById(int id);

}
