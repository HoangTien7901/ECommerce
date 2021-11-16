package com.demo.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.BannerInfo;
import com.demo.services.manager.IBannerService;

@Controller
@RequestMapping("manager/banner")
public class BannerController {

	@Autowired
	private IBannerService service;
	
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<Iterable<BannerInfo>> responseEntity = service.findAllInfo() ;
		if( responseEntity != null ) {
			if( responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("banners", responseEntity.getBody());
			}
		}		
		return "manager/banner/index";
	}
	
	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<BannerInfo> responseEntity = service.findInfoById(id);
		BannerInfo banner = responseEntity.getBody();
		if( responseEntity != null ) {
			if( responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("banner", banner);
			}
		}		
		return "manager/banner/edit";
	}
	
	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("banner") BannerInfo banner) {
		ResponseEntity<Void> responseEntity = service.update(banner);
		
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
			// success
		} else {
			// failed
		}	
		return "redirect:/manager/banner/index";
	}
	
}