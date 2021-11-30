package com.demo.controllers.manager;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.helpers.MailHelper;
import com.demo.models.FeedbackInfo;
import com.demo.models.UserInfo;
import com.demo.services.manager.IFeedbackService;
import com.demo.services.manager.ISystemService;
import com.demo.services.manager.IUserService;

@Controller
@RequestMapping("manager/system")
public class SystemController {

	@Autowired
	private ISystemService service;
	
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<com.demo.models.System> responseEntity = service.getSystem();
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("title", "Manage system");
				modelMap.put("systemActive", "active");
				modelMap.put("adminOpen", true);

				modelMap.put("item", responseEntity.getBody());
				modelMap.put("pageTitle", "System");
			}
		}
		return "manager/system/index";
	}


	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") @Valid com.demo.models.System item, BindingResult errors, ModelMap modelMap) {
		
		if (errors.hasErrors()) {
			System.out.println("has errors");
			
			modelMap.put("title", "Manage system");
			modelMap.put("systemActive", "active");
			modelMap.put("adminOpen", true);

			modelMap.put("pageTitle", "System");
			return "manager/system/index";
		} else {
			com.demo.models.System object = item;
			object.setId(1);
			ResponseEntity<Void> responseEntity = service.update(object);
			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
//				FeedbackInfo result = responseEntity.getBody();
			} else {
				System.out.println("Client - Update system result" + responseEntity == null ? "null"
						: responseEntity.getStatusCode());
			}

			return "redirect:/manager/system/index";
		}
	}

}