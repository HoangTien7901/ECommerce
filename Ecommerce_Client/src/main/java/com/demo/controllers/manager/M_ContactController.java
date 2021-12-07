package com.demo.controllers.manager;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entities.Contacts;
import com.demo.services.manager.IContactService;
import com.demo.validators.ContactValidator;

@Controller
@RequestMapping("manager/contact")
public class M_ContactController {

	@Autowired
	private ContactValidator validator;

	@Autowired
	private IContactService contactService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<Contacts> responseEntity = contactService.getContact();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("title", "Manage contact");
			modelMap.put("contactActive", "active");

			modelMap.put("adminOpen", true);
			
			modelMap.put("item", responseEntity.getBody());
			modelMap.put("pageTitle", "Contact info");
		} else {
			modelMap.put("msg", "Server - Get contact info result "
					+ (responseEntity == null ? "null"
							: responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/contact/index";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") @Valid Contacts item, BindingResult errors, ModelMap modelMap
			, RedirectAttributes redirectAttr) {

		validator.validate(item, errors);
		if (errors.hasErrors()) {
			modelMap.put("title", "Manage contact");
			modelMap.put("contactActive", "active");

			modelMap.put("pageTitle", "Contact info");

			return "manager/contact/index";
		} else {
			ResponseEntity<Void> responseEntity = contactService.update(item);
			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
				redirectAttr.addFlashAttribute("msg", "Update success!");
				redirectAttr.addFlashAttribute("msgType", "success");
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Update contact result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}
		}

		return "redirect:/manager/contact/index";
	}

}