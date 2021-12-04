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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		modelMap.put("title", "Manage branch");
		modelMap.put("branchActive", "active");
		
		modelMap.put("pageTitle", "Branch list");
		modelMap.put("parentPageTitle", "Branch");
		
		ResponseEntity<Iterable<BranchInfo>> responseEntity = branchService.findAllInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("items", responseEntity.getBody());
		} else {
			modelMap.put("msg", "Server - Get all branch result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/branch/index";
	}

	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<BranchInfo> responseEntity = branchService.findInfoById(id);
		BranchInfo result = responseEntity.getBody();
		
		modelMap.put("title", "Edit branch");
		modelMap.put("branchActive", "active");
		
		modelMap.put("pageTitle", "Edit");
		modelMap.put("parentPageTitle", "Branch");
		
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("id", result.getId());
			modelMap.put("name", result.getName());
			modelMap.put("currentLogo", result.getLogo());
		} else {
			modelMap.put("msg", "Server - Get branch by id result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/branch/edit";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@RequestParam("id") int id, @RequestParam("name") String name, 
			@RequestParam(value = "logo", required = false) MultipartFile logo
			, RedirectAttributes redirectAttr) {
		ResponseEntity<BranchInfo> response = branchService.findInfoById(id);
		
		if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {
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
			if (!(response2 == null || response2.getStatusCode() != HttpStatus.OK)) {
				redirectAttr.addFlashAttribute("msg", "Update success!");
				redirectAttr.addFlashAttribute("msgType", "success");
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Update branch result " + (response2 == null ? "null" : response2.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Find branch by id result " + (response == null ? "null" : response.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
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
	public String create(@RequestParam("name") String name, @RequestParam(name = "logo", required = false)  MultipartFile logo, RedirectAttributes redirectAttr) {
		BranchInfo item = new BranchInfo();
		item.setName(name);
		
		if (!logo.isEmpty()) {
			String fileName = FileUploadHelper.upload(logo, servletContext);
			item.setLogo(fileName);
		} else {
			item.setLogo("defaultLogo.png");
		}
		
		ResponseEntity<BranchInfo> responseEntity = branchService.create(item);
		
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			redirectAttr.addFlashAttribute("msg", "Add success!");
			redirectAttr.addFlashAttribute("msgType", "success");
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Add branch result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}

		return "redirect:/manager/branch/index";
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttr) {
		ResponseEntity<Void> responseEntity = branchService.delete(id);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			redirectAttr.addFlashAttribute("msg", "Delete success!");
			redirectAttr.addFlashAttribute("msgType", "success");
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Delete branch result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}
		
		return "redirect:/manager/branch/index";
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}