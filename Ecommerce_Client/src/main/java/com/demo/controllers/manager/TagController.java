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

import com.demo.models.TagInfo;
import com.demo.services.manager.ITagService;

@Controller
@RequestMapping("manager/tag")
public class TagController {

	@Autowired
	private ITagService tagService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<Iterable<TagInfo>> responseEntity = tagService.findAllInfo();
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("title", "Manage tag");
				modelMap.put("tagActive", "active");

				modelMap.put("items", responseEntity.getBody());
				modelMap.put("pageTitle", "Tag list");
				modelMap.put("parentPageTitle", "Tag");
			}
		}
		return "manager/tag/index";
	}

	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<TagInfo> responseEntity = tagService.findInfoById(id);

		TagInfo result = responseEntity.getBody();

		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("title", "Edit tag");
				modelMap.put("tagActive", "active");

				modelMap.put("item", result);
				modelMap.put("pageTitle", "Edit");
				modelMap.put("parentPageTitle", "Tag");
			}
		}
		return "manager/tag/edit";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") @Valid TagInfo item, BindingResult errors, ModelMap modelMap) {

		if (errors.hasErrors()) {
			modelMap.put("title", "Edit tag");
			modelMap.put("tagActive", "active");

			modelMap.put("pageTitle", "Edit");
			modelMap.put("parentPageTitle", "Tag");

			return "manager/tag/edit";
		} else {
			ResponseEntity<Void> responseEntity = tagService.update(item);
			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
//				TagInfo result = responseEntity.getBody();
			} else {
				System.out.println("Client - Update tag result "
						+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			}

			return "redirect:/manager/tag/index";
		}
	}

	@RequestMapping(value = { "add" }, method = RequestMethod.GET)
	public String add(ModelMap modelMap) {

		ResponseEntity<Iterable<TagInfo>> responseEntityForSelect = tagService.findAllInfo();
		if (responseEntityForSelect != null) {
			if (responseEntityForSelect.getStatusCode() == HttpStatus.OK) {
				modelMap.put("items", (List<TagInfo>) responseEntityForSelect.getBody());
			}
		}

		TagInfo item = new TagInfo();

		modelMap.put("title", "Add tag");
		modelMap.put("tagActive", "active");

		modelMap.put("item", item);
		modelMap.put("pageTitle", "Add");
		modelMap.put("parentPageTitle", "Tag");

		return "manager/tag/add";
	}

	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("item") @Valid TagInfo item, BindingResult errors, ModelMap modelMap) {

		if (errors.hasErrors()) {
			modelMap.put("title", "Add tag");
			modelMap.put("tagActive", "active");

			modelMap.put("pageTitle", "Add");
			modelMap.put("parentPageTitle", "Tag");

			return "manager/tag/add";
		} else {

			ResponseEntity<TagInfo> responseEntity = tagService.create(item);

			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
//			TagInfo result = responseEntity.getBody();
			} else {
				System.out.println(
						"Client - Add tag result " + responseEntity == null ? "null" : responseEntity.getStatusCode());
			}

			return "redirect:/manager/tag/index";
		}
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		ResponseEntity<Void> responseEntity = tagService.delete(id);
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {

			} else {

			}
		}
		return "redirect:/manager/tag/index";
	}
}