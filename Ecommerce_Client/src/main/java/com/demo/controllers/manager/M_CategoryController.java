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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.models.BannerInfo;
import com.demo.models.CategoryInfo;
import com.demo.services.manager.ICategoryService;
import com.demo.validators.CategoryValidator;

@Controller
@RequestMapping("manager/category")
public class M_CategoryController {

	@Autowired
	private CategoryValidator validator;

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("title", "Manage category");
		modelMap.put("categoryActive", "active");

		modelMap.put("pageTitle", "Category list");
		modelMap.put("parentPageTitle", "Category");

		ResponseEntity<Iterable<CategoryInfo>> responseEntity = categoryService.findAllInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("items", responseEntity.getBody());
		} else {
			modelMap.put("msg", "Server - Get all category result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/category/index";
	}

	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("title", "Edit category");
		modelMap.put("categoryActive", "active");

		modelMap.put("pageTitle", "Edit");
		modelMap.put("parentPageTitle", "Category");

		ResponseEntity<CategoryInfo> responseEntity = categoryService.findInfoById(id);
		
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			CategoryInfo result = responseEntity.getBody();
			modelMap.put("item", result);
			
			ResponseEntity<Iterable<CategoryInfo>> responseEntityForSelect = categoryService.findAllExcept(id,
					result.getLevel());
			if (!(responseEntityForSelect == null || responseEntityForSelect.getStatusCode() != HttpStatus.OK)) {
				modelMap.put("items", (List<CategoryInfo>) responseEntityForSelect.getBody());
			} else {
				modelMap.put("msg", "Server - Get all user for selection result "
						+ (responseEntityForSelect == null ? "null" : responseEntityForSelect.getStatusCode()));
				modelMap.put("msgType", "danger");
			}
		} else {
			modelMap.put("msg", "Server - Get category by id result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}

		return "manager/category/edit";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") @Valid CategoryInfo item, BindingResult errors, ModelMap modelMap
			, RedirectAttributes redirectAttr) {
		validator.validate(item, errors);
		if (errors.hasErrors()) {
			modelMap.put("title", "Edit category");
			modelMap.put("categoryActive", "active");

			modelMap.put("pageTitle", "Edit");
			modelMap.put("parentPageTitle", "Category");

			return "manager/category/edit";
		} else {
			ResponseEntity<Void> responseEntity = categoryService.update(item);
			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
				redirectAttr.addFlashAttribute("msg", "Update success!");
				redirectAttr.addFlashAttribute("msgType", "success");
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Update category error " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}
		}

		return "redirect:/manager/category/index";
	}

	@RequestMapping(value = { "add" }, method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		CategoryInfo item = new CategoryInfo();
		
		modelMap.put("title", "Add category");
		modelMap.put("categoryActive", "active");

		modelMap.put("item", item);
		
		modelMap.put("pageTitle", "Add");
		modelMap.put("parentPageTitle", "Category");
		
		ResponseEntity<Iterable<CategoryInfo>> responseEntityForSelect = categoryService.findAllForSelection();
		if (!(responseEntityForSelect == null || responseEntityForSelect.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("items", (List<CategoryInfo>) responseEntityForSelect.getBody());
		} else {
			modelMap.put("msg", "Server - Get categories for selection result "
					+ (responseEntityForSelect == null ? "null" : responseEntityForSelect.getStatusCode()));
			modelMap.put("msgType", "danger");
		}

		return "manager/category/add";
	}

	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("item") @Valid CategoryInfo item, BindingResult errors, ModelMap modelMap
			, RedirectAttributes redirectAttr) {

		validator.validate(item, errors);
		if (errors.hasErrors()) {
			modelMap.put("title", "Add category");
			modelMap.put("categoryActive", "active");

			modelMap.put("pageTitle", "Add");
			modelMap.put("parentPageTitle", "Category");

			return "manager/category/add";
		} else {
			ResponseEntity<CategoryInfo> responseEntity = categoryService.create(item);

			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
				redirectAttr.addFlashAttribute("msg", "Add success!");
				redirectAttr.addFlashAttribute("msgType", "success");
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Get categories for selection result "
						+ (responseEntity == null ? "null"
								: responseEntity.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}

			return "redirect:/manager/category/index";
		}
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id
			, RedirectAttributes redirectAttr) {
		ResponseEntity<Void> responseEntity = categoryService.delete(id);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			redirectAttr.addFlashAttribute("msg", "Delete success!");
			redirectAttr.addFlashAttribute("msgType", "success");
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Delete category result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}
		return "redirect:/manager/category/index";
	}
}