package com.demo.services;

import org.springframework.http.ResponseEntity;

import com.demo.models.ImageInfo;

public interface ImageService {
	
	public ResponseEntity<ImageInfo> create(ImageInfo imageInfo);
	
}
