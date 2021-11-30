package com.demo.controllers.manager;


import java.util.List;

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

import com.demo.models.ServiceInfo;
import com.demo.services.manager.IServiceService;

@Controller
@RequestMapping("manager/service")
public class ServiceController {

	@Autowired
	private IServiceService service;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<Iterable<ServiceInfo>> responseEntity = service.findAllInfo();
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("title", "Manage service");
				modelMap.put("serviceActive", "active");
				
				modelMap.put("items", responseEntity.getBody());
				modelMap.put("pageTitle", "Service list");
				modelMap.put("parentPageTitle", "Service");
			}
		}
		return "manager/service/index";
	}

	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<ServiceInfo> responseEntity = service.findInfoById(id);
		
		ServiceInfo result = responseEntity.getBody();
		
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("title", "Edit service");
				modelMap.put("serviceActive", "active");
				
				modelMap.put("item", result);
				modelMap.put("pageTitle", "Edit");
				modelMap.put("parentPageTitle", "Service");
			}
		}
		return "manager/service/edit";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") @Valid ServiceInfo _object, BindingResult errors, ModelMap modelMap) {
		
		if (errors.hasErrors()) {
			modelMap.put("title", "Edit service");
			modelMap.put("serviceActive", "active");
			
			modelMap.put("pageTitle", "Edit");
			modelMap.put("parentPageTitle", "Service");
			
			return "manager/service/edit";
		} else {
			ServiceInfo object = _object;
			
			// change after login function
			object.setUpdaterId(1);
			
			ResponseEntity<Void> responseEntity = service.update(object);
			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
//				ServiceInfo result = responseEntity.getBody();
			} else {
				System.out.println("Client - Update service result" + responseEntity == null ? "null" : responseEntity.getStatusCode());
			}

			return "redirect:/manager/service/index";
		}
	}
	
	@RequestMapping(value = { "add" }, method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		
		ResponseEntity<Iterable<ServiceInfo>> responseEntityForSelect = service.findAllInfo();
		if (responseEntityForSelect != null) {
			if (responseEntityForSelect.getStatusCode() == HttpStatus.OK) {
				modelMap.put("items", (List<ServiceInfo>) responseEntityForSelect.getBody());
			}
		}
		
		ServiceInfo item = new ServiceInfo();

		modelMap.put("title", "Add service");
		modelMap.put("serviceActive", "active");
		
		modelMap.put("item", item);
		modelMap.put("pageTitle", "Add");
		modelMap.put("parentPageTitle", "Service");
		
		return "manager/service/add";
	}
	
	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("item") @Valid ServiceInfo _object, BindingResult errors, ModelMap modelMap) {
		
		if (errors.hasErrors()) {
			modelMap.put("title", "Add service");
			modelMap.put("serviceActive", "active");
			
			modelMap.put("pageTitle", "Add");
			modelMap.put("parentPageTitle", "Service");
			
			return "manager/service/add";
			
		} else {
			ServiceInfo object = _object;
			
			// change after login function
			object.setCreatorId(1);
			
			ResponseEntity<ServiceInfo> responseEntity = service.create(object);
			
			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
//				ServiceInfo result = responseEntity.getBody();
			} else {
				System.out.println("Client - Add service result" + responseEntity == null ? "null" : responseEntity.getStatusCode());
			}

			return "redirect:/manager/service/index";
		}
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		ResponseEntity<Void> responseEntity = service.delete(id);
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {

			} else {

			}
		}
		return "redirect:/manager/service/index";
	}
}