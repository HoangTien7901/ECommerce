package com.demo.services.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Banners;
import com.demo.entities.Images;
import com.demo.models.ImageInfo;
import com.demo.repositories.manager.IBannerRepository;
import com.demo.repositories.manager.IImageRepository;

@Service("image")
public class ImageService implements IImageService {

	@Autowired
	private IBannerRepository bannerRepos;
	
	@Autowired
	private IImageRepository imgRepos;

	@Override
	public Iterable<ImageInfo> findAllInfo() {
		return imgRepos.findAllInfo();
	}

	@Override
	public ImageInfo findInfoById(int id) {
		return imgRepos.findInfoById(id);
	}

	@Override
	public Images findById(int id) {
		// TODO Auto-generated method stub
		return imgRepos.findById(id).get();
	}
	
	@Override
	public ImageInfo add(ImageInfo imgInfo) {
		Images img = new Images();
		img.setName(imgInfo.getName());
		
		if (imgInfo.getBannerId() != null) {
			Banners banner = bannerRepos.findById(imgInfo.getBannerId()).get();
			img.setBanners(banner);
		}
		
		if (imgInfo.getProductId() != null) {
//			img.setProducts(bannerRepos.findById(imgInfo.getBannerId()).get());
		}
		
		try {
			img = imgRepos.save(img);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return imgRepos.findInfoById(img.getId());
	}

	@Override 
	public ImageInfo update(int id, ImageInfo imgInfo) 
	{ 
		return imgRepos.findInfoById(id); 
	}

	@Override
	public void delete(int id) {
		imgRepos.delete(imgRepos.findById(id).get());
	}
	
	@Override
	public void deleteAllByBannerId(int id) {
		imgRepos.deleteByBannersId(id);
	}

	@Override
	public Iterable<ImageInfo> findAllInfoByBannerId(int id) {
		return imgRepos.findAllInfoByBannerId(id);
	}	
}
