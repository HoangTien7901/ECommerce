package com.demo.services.manager;

import com.demo.entities.Banners;
import com.demo.models.BannerInfo;

public interface IBannerService {

	public Iterable<BannerInfo> findAllInfo();
	
	public BannerInfo findInfoById(int id);
	
	public Banners findById(int id);
	
	public BannerInfo update(int id, BannerInfo banner);

}
