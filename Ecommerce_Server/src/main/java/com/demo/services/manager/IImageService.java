package com.demo.services.manager;

import com.demo.entities.Images;
import com.demo.models.ImageInfo;

public interface IImageService {

	public Iterable<ImageInfo> findAllInfo();
	
	public Iterable<ImageInfo> findAllInfoByBannerId(int id);
	
	public ImageInfo findInfoById(int id);
	
	public Images findById(int id);
	
	public ImageInfo update(int id, ImageInfo image);
	
	public void delete(int id);
	
	public void deleteAllByBannerId(int id);
	
	public ImageInfo add(ImageInfo image);

}
