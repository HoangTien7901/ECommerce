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
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.helpers.MailHelper;
import com.demo.models.FeedbackInfo;
import com.demo.models.UserInfo;
import com.demo.services.manager.IFeedbackService;
import com.demo.services.manager.IUserService;

@Controller
@RequestMapping("manager/feedback")
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;
	
	@Autowired
	private IUserService userService;

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

	@RequestMapping(value = { "sendMail/{id}" }, method = RequestMethod.GET)
	public String sendMail(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<FeedbackInfo> responseEntity = feedbackService.findInfoById(id);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			FeedbackInfo feedbackInfo = responseEntity.getBody();
			
			modelMap.put("title", "Manage feedback");
			modelMap.put("feedbackActive", "active");

			modelMap.put("userId", feedbackInfo.getUserId());
			modelMap.put("content", feedbackInfo.getContent());
			modelMap.put("username", feedbackInfo.getUsername());
			modelMap.put("pageTitle", "Reply user's feedback");
			modelMap.put("parentPageTitle", "Feedback");
		} else {
			System.out.println(
					"Client - Get feedback result " + responseEntity == null ? "null" : responseEntity.getStatusCode());
		}
		return "manager/feedback/sendMail";
	}
	
	@RequestMapping(value = { "sendMail" }, method = RequestMethod.POST)
	public String sendMail(@RequestParam("userId") int userId, @RequestParam("subject") String subject, @RequestParam("content") String content,
			@RequestParam(value = "isHTMLText", required = false) boolean isHTMLText) {
		ResponseEntity<UserInfo> responseEntity = userService.findInfoById(userId);
		
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			UserInfo user = responseEntity.getBody();
			
			// send mail
			MailHelper mailHelper = new MailHelper();
			try {
//				mailHelper.sendmail("<email>", "<password>", subject, content, user.getEmail(), isHTMLText);
			} catch (Exception e) {
				System.out.println("Client feedback send mail failed: " + e.getMessage());
			}
		} else {
			System.out.println(
					"Client - Get feedback result " + responseEntity == null ? "null" : responseEntity.getStatusCode());
		}
		return "redirect:/manager/feedback/index";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") FeedbackInfo item) {
		ResponseEntity<FeedbackInfo> responseEntity = feedbackService.create(item);
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
//			FeedbackInfo result = responseEntity.getBody();
		} else {
			System.out.println("Client - Update feedback result" + responseEntity == null ? "null"
					: responseEntity.getStatusCode());
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