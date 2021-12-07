package com.demo.services.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Banners;
import com.demo.entities.Users;
import com.demo.models.BannerInfo;
import com.demo.repositories.manager.IBannerRepository;
import com.demo.repositories.manager.IUserRepository;

@Service("banner")
public class BannerService implements IBannerService {

	@Autowired
	private IBannerRepository bannerRepos;

	@Autowired
	private IUserRepository userRepos;

	@Override
	public Iterable<BannerInfo> findAllInfo() {
		return bannerRepos.findAllInfo();
	}

	@Override
	public BannerInfo findInfoById(int id) {
		return bannerRepos.findInfoById(id);
	}
	
	@Override
	public BannerInfo findInfoActive() {
		return bannerRepos.findInfoActive();
	}

	@Override
	public Banners findById(int id) {
		return bannerRepos.findById(id).get();
	}

	@Override
	public BannerInfo add(BannerInfo bannerInfo) {
		Banners banner = new Banners();
		banner.setCaption(bannerInfo.getCaption());
		banner.setDescription(bannerInfo.getDescription());
		banner.setLink(bannerInfo.getLink());
		banner.setStatus(bannerInfo.isStatus());
		banner.setCreated(new Date());
		
		Users user = userRepos.findById(bannerInfo.getCreatorId()).get();

		banner.setUsersByCreaterId(user);
		banner = bannerRepos.save(banner);

		if (bannerInfo.isStatus()) {
			bannerRepos.turnOffAllExcept(banner.getId());
		}
		return bannerRepos.findInfoById(banner.getId());
	}

	@Override
	public BannerInfo update(int id, BannerInfo bannerInfo) {
		try {
			Banners banner = bannerRepos.findById(id).get();

			banner.setCaption(bannerInfo.getCaption());
			banner.setDescription(bannerInfo.getDescription());
			banner.setLink(bannerInfo.getLink());
			banner.setStatus(bannerInfo.isStatus());
			banner.setUpdated(new Date());

			Users user = userRepos.findById(bannerInfo.getUpdatorId()).get();

			banner.setUsersByUpdaterId(user);

			bannerRepos.save(banner);

			if (bannerInfo.isStatus()) {
				bannerRepos.turnOffAllExcept(id);
			}
			
		} catch (Exception e) {
			System.out.println("Server exception: " + e.getMessage());
			e.printStackTrace();
		}

		return bannerRepos.findInfoById(id);
	}

	@Override
	public void delete(int id) {
		Banners banner = bannerRepos.findById(id).get();
		bannerRepos.delete(banner);
	}
}
