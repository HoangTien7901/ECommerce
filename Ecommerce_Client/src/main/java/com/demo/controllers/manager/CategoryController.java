package com.demo.controllers.manager;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.BannerInfo;
import com.demo.models.CategoryInfo;
import com.demo.services.manager.ICategoryService;

@Controller
@RequestMapping("manager/category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<Iterable<CategoryInfo>> responseEntity = categoryService.findAllInfo();
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("title", "Manage category");
				modelMap.put("categoryActive", "active");
				
				modelMap.put("items", responseEntity.getBody());
				modelMap.put("pageTitle", "Category list");
				modelMap.put("parentPageTitle", "Category");
			}
		}
		return "manager/category/index";
	}

	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<CategoryInfo> responseEntity = categoryService.findInfoById(id);
		
		CategoryInfo result = responseEntity.getBody();
		
		ResponseEntity<Iterable<CategoryInfo>> responseEntityForSelect = categoryService.findAllExcept(id, result.getLevel());
		if (responseEntityForSelect != null) {
			if (responseEntityForSelect.getStatusCode() == HttpStatus.OK) {
				modelMap.put("items", (List<CategoryInfo>) responseEntityForSelect.getBody());
			}
		}
		
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("title", "Edit category");
				modelMap.put("categoryActive", "active");
				
				modelMap.put("item", result);
				modelMap.put("pageTitle", "Edit");
				modelMap.put("parentPageTitle", "Category");
			}
		}
		return "manager/category/edit";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") CategoryInfo item) {
		ResponseEntity<Void> responseEntity = categoryService.update(item);
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
//			CategoryInfo result = responseEntity.getBody();
		} else {
			System.out.println("Client - Update category result" + responseEntity == null ? "null" : responseEntity.getStatusCode());
		}

		return "redirect:/manager/category/index";
	}
	
	@RequestMapping(value = { "add" }, method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		
		ResponseEntity<Iterable<CategoryInfo>> responseEntityForSelect = categoryService.findAllInfo();
		if (responseEntityForSelect != null) {
			if (responseEntityForSelect.getStatusCode() == HttpStatus.OK) {
				modelMap.put("items", (List<CategoryInfo>) responseEntityForSelect.getBody());
			}
		}
		
		CategoryInfo item = new CategoryInfo();

		modelMap.put("title", "Add category");
		modelMap.put("categoryActive", "active");
		
		modelMap.put("item", item);
		modelMap.put("pageTitle", "Add");
		modelMap.put("parentPageTitle", "Category");
		
		return "manager/category/add";
	}
	
	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("item") CategoryInfo item) {
		
		ResponseEntity<CategoryInfo> responseEntity = categoryService.create(item);
		
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
//			CategoryInfo result = responseEntity.getBody();
		} else {
			System.out.println("Client - Add category result" + responseEntity == null ? "null" : responseEntity.getStatusCode());
		}

		return "redirect:/manager/category/index";
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		ResponseEntity<Void> responseEntity = categoryService.delete(id);
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {

			} else {

			}
		}
		return "redirect:/manager/category/index";
	}
}