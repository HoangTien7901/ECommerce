package com.demo.services.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Banners;
import com.demo.models.BannerInfo;
import com.demo.repositories.manager.IBannerRepository;

@Service("banner")
public class BannerService implements IBannerService {

	@Autowired
	private IBannerRepository repos;

	@Override
	public Iterable<BannerInfo> findAllInfo() {
		return repos.findAllInfo();
	}

	@Override
	public BannerInfo findInfoById(int id) {
		return repos.findInfoById(id);
	}

	@Override
	public Banners findById(int id) {
		// TODO Auto-generated method stub
		return repos.findById(id).get();
	}

	@Override 
	public BannerInfo update(int id, BannerInfo bannerInfo) 
	{ 
		Banners banner = repos.findById(id).get();
		
		banner.setCaption(bannerInfo.getCaption());
		banner.setDescription(bannerInfo.getDescription());
		banner.setLink(bannerInfo.getLink());
		banner.setStatus(bannerInfo.isStatus());
		
		repos.save(banner);
		return repos.findInfoById(id); 
	}

}
