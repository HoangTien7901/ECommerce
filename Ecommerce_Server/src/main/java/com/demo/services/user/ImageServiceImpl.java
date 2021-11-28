package com.demo.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.ImagesInfor;

import com.demo.repositories.user.ImageRepositories;

@Service("imageService")
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageRepositories imageRepositories;
	

	@Override
	public List<ImagesInfor> findAllImages() {
		return imageRepositories.findAllImages();
		
	}


	@Override
	public List<ImagesInfor> imageByIdProduct(int id) {
		return imageRepositories.findImageByIdProduct(id);
	}
}
