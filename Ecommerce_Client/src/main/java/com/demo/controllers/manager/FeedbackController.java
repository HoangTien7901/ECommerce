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

import com.demo.models.FeedbackInfo;
import com.demo.services.manager.IFeedbackService;

@Controller
@RequestMapping("manager/feedback")
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<Iterable<FeedbackInfo>> responseEntity = feedbackService.findAllInfo();
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("title", "Manage feedback");
				modelMap.put("feedbackActive", "active");
				
				modelMap.put("items", responseEntity.getBody());
				modelMap.put("pageTitle", "Feedback list");
				modelMap.put("parentPageTitle", "Feedback");
			}
		}
		return "manager/feedback/index";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") FeedbackInfo item) {
		ResponseEntity<FeedbackInfo> responseEntity = feedbackService.create(item);
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
//			FeedbackInfo result = responseEntity.getBody();
		} else {
			System.out.println("Client - Update feedback result" + responseEntity == null ? "null" : responseEntity.getStatusCode());
		}

		return "redirect:/manager/feedback/index";
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		ResponseEntity<Void> responseEntity = feedbackService.delete(id);
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {

			} else {

			}
		}
		return "redirect:/manager/feedback/index";
	}
	
	@RequestMapping(value = { "toggleStatus/{id}" }, method = RequestMethod.GET)
	public String toggleStatus(@PathVariable("id") int id) {
		ResponseEntity<Void> responseEntity = feedbackService.toggleStatus(id);
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {

			} else {

			}
		}
		return "redirect:/manager/feedback/index";
	}
}