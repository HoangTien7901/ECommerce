package com.demo.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.ImageInfo;

@Service("imageService")
public class ImageServiceIplm implements ImageService {
	
	private String BASE_URL = "http://localhost:9596/api/image/";	

	@Override
	public ResponseEntity<ImageInfo> create(ImageInfo imageInfo) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.postForEntity(BASE_URL + "create", imageInfo, ImageInfo.class);
		} catch (Exception e) {
			return null;
		}
	}
	
}
