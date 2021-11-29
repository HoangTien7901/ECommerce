package com.demo.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Images;
import com.demo.repositories.user.ImageRepository;

@Service("imageService")
public class ImageServiceIplm implements ImageService {
	
	@Autowired
	private ImageRepository imageRepository;

	@Override
	public Images create(Images image) {
		return imageRepository.save(image);
	}

}
