package com.demo.controllers.manager;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.demo.helpers.FileUploadHelper;
import com.demo.models.BannerInfo;
import com.demo.models.ImageInfo;
import com.demo.services.manager.IBannerService;
import com.demo.services.manager.IImageService;

@Controller
@RequestMapping("manager/banner")
public class BannerController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired
	private IBannerService bannerService;

	@Autowired
	private IImageService imageService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<Iterable<BannerInfo>> responseEntity = bannerService.findAllInfo();
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("banners", responseEntity.getBody());
				modelMap.put("pageTitle", "Banner list");
				modelMap.put("parentPageTitle", "Banner");
			}
		}
		return "manager/banner/index";
	}

	@RequestMapping(value = { "add" }, method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		BannerInfo banner = new BannerInfo();

		banner.setCreatorId(1);
		// change after login function

		modelMap.put("banner", banner);
		modelMap.put("pageTitle", "Add");
		modelMap.put("parentPageTitle", "Banner");

		return "manager/banner/add";
	}

	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("banner") BannerInfo banner, @RequestParam("photos") MultipartFile[] photos) {

		ResponseEntity<BannerInfo> responseEntity = bannerService.create(banner);
		System.out.println("Client 1: status " + banner.isStatus());
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
			BannerInfo result = responseEntity.getBody();
			System.out.println("Client 2: result " + result == null ? "null" : result.getCaption());
			
			int bannerId = result.getId();
			for (MultipartFile photo : photos) {
				String fileName = FileUploadHelper.upload(photo, servletContext);

				ImageInfo img = new ImageInfo();
				img.setName(fileName);
				img.setBannerId(bannerId);
				
				ResponseEntity<ImageInfo> responseEntity2 = imageService.create(img);
				
				if (responseEntity2 != null && responseEntity2.getStatusCode() == HttpStatus.OK) {
					// success
				} else {
					// failed
				}
			}
		} else {
			System.out.println("Client - Create banner result" + responseEntity == null ? "null" : responseEntity.getStatusCode());
		}
		return "redirect:/manager/banner/index";
	}

	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<BannerInfo> responseEntity = bannerService.findInfoById(id);

		BannerInfo banner = responseEntity.getBody();

		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("banner", banner);
				modelMap.put("pageTitle", "Edit");
				modelMap.put("parentPageTitle", "Banner");
			}
		}
		return "manager/banner/edit";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("banner") BannerInfo banner, @RequestParam("photos") MultipartFile[] photos) {
		BannerInfo newBanner = new BannerInfo();
		newBanner.setCaption(banner.getCaption());
		newBanner.setCreated(banner.getCreated());
		newBanner.setDescription(banner.getDescription());
		newBanner.setCreatorId(banner.getCreatorId());
		newBanner.setLink(banner.getLink());
		newBanner.setStatus(banner.isStatus());
		
		newBanner.setUpdatorId(1);
		// get current user and set updator id here, this is just for testing
		
		ResponseEntity<BannerInfo> responseEntity = bannerService.create(newBanner);
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
			BannerInfo result = responseEntity.getBody();
			int bannerId = result.getId();
			for (MultipartFile photo : photos) {
				String fileName = FileUploadHelper.upload(photo, servletContext);

				ImageInfo img = new ImageInfo();
				img.setName(fileName);
				img.setBannerId(bannerId);
				
				ResponseEntity<ImageInfo> responseEntity2 = imageService.create(img);
				
				if (responseEntity2 != null && responseEntity2.getStatusCode() == HttpStatus.OK) {
					// success
				} else {
					// failed
				}
			}
		} else {
			System.out.println("Client - Create banner result" + responseEntity == null ? "null" : responseEntity.getStatusCode());
		}

		return "redirect:/manager/banner/index";
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		ResponseEntity<Void> responseEntity = bannerService.delete(id);
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {

			} else {

			}
		}
		return "redirect:/manager/banner/index";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}