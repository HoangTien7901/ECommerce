package com.demo.services.user;

import java.util.List;
import com.demo.models.ImagesInfor;

public interface ImageService {
	
	public List<ImagesInfor> findAllImages();
	
	public List<ImagesInfor> imageByIdProduct(int id);
	
	
}

