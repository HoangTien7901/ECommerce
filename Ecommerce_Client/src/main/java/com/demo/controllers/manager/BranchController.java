package com.demo.controllers.manager;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.demo.helpers.FileUploadHelper;
import com.demo.models.BranchInfo;
import com.demo.services.manager.IBranchService;

@Controller
@RequestMapping("manager/branch")
public class BranchController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired
	private IBranchService branchService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<Iterable<BranchInfo>> responseEntity = branchService.findAllInfo();
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("title", "Manage branch");
				modelMap.put("branchActive", "active");
				
				modelMap.put("items", responseEntity.getBody());
				modelMap.put("pageTitle", "Branch list");
				modelMap.put("parentPageTitle", "Branch");
			}
		}
		return "manager/branch/index";
	}

	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<BranchInfo> responseEntity = branchService.findInfoById(id);
		
		BranchInfo result = responseEntity.getBody();
		
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("title", "Edit branch");
				modelMap.put("branchActive", "active");
				
				modelMap.put("id", result.getId());
				modelMap.put("name", result.getName());
				modelMap.put("currentLogo", result.getLogo());
				
				modelMap.put("pageTitle", "Edit");
				modelMap.put("parentPageTitle", "Branch");
			}
		}
		return "manager/branch/edit";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@RequestParam("id") int id, @RequestParam("name") String name, 
			@RequestParam(value = "logo", required = false) MultipartFile logo) {
		ResponseEntity<BranchInfo> response = branchService.findInfoById(id);
		
		if (response != null && response.getStatusCode() == HttpStatus.OK) {
			BranchInfo object = response.getBody();
			object.setName(name);
			
			if (!logo.isEmpty()) {
				String fileName = FileUploadHelper.upload(logo, servletContext);
				object.setLogo(fileName);
			} else {
				if (object.getLogo().isEmpty()) {
					object.setLogo("defaultLogo.png");
				}
			}
			
			ResponseEntity<Void> response2 = branchService.update(object);
			if (response2 != null && response2.getStatusCode() == HttpStatus.OK) {
//				BranchInfo result = responseEntity.getBody();
			} else {
				System.out.println("Client - Update branch error " + response2 == null ? "null" : response2.getStatusCode());
			}
		} else {
			System.out.println("Client - Save - Find branch by id error " + response == null ? "null" : response.getStatusCode());
		}
		
		return "redirect:/manager/branch/index";
	}
	
	@RequestMapping(value = { "add" }, method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		BranchInfo item = new BranchInfo();

		modelMap.put("title", "Add branch");
		modelMap.put("branchActive", "active");
		
		modelMap.put("pageTitle", "Add");
		modelMap.put("parentPageTitle", "Branch");
		
		return "manager/branch/add";
	}
	
	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@RequestParam("name") String name, @RequestParam(name = "logo", required = false)  MultipartFile logo) {
		BranchInfo item = new BranchInfo();
		item.setName(name);
		
		if (!logo.isEmpty()) {
			String fileName = FileUploadHelper.upload(logo, servletContext);
			item.setLogo(fileName);
		} else {
			item.setLogo("defaultLogo.png");
		}
		
		ResponseEntity<BranchInfo> responseEntity = branchService.create(item);
		
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
//			BranchInfo result = responseEntity.getBody();
		} else {
			System.out.println("Client - Add branch result" + responseEntity == null ? "null" : responseEntity.getStatusCode());
		}

		return "redirect:/manager/branch/index";
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		ResponseEntity<Void> responseEntity = branchService.delete(id);
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {

			} else {

			}
		}
		return "redirect:/manager/branch/index";
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}