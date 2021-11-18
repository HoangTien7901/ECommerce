package com.demo.controllers.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("item", result);
				modelMap.put("pageTitle", "Edit");
				modelMap.put("parentPageTitle", "Category");
			}
		}
		return "manager/category/edit";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") CategoryInfo item) {
		ResponseEntity<CategoryInfo> responseEntity = categoryService.create(item);
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
//			CategoryInfo result = responseEntity.getBody();
		} else {
			System.out.println("Client - Update category result" + responseEntity == null ? "null" : responseEntity.getStatusCode());
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