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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.helpers.MailHelper;
import com.demo.models.FeedbackInfo;
import com.demo.models.UserInfo;
import com.demo.services.manager.IFeedbackService;
import com.demo.services.manager.ISystemService;
import com.demo.services.manager.IUserService;

@Controller
@RequestMapping("manager/feedback")
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISystemService systemService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("title", "Manage feedback");
		modelMap.put("feedbackActive", "active");

		modelMap.put("pageTitle", "Feedback list");
		modelMap.put("parentPageTitle", "Feedback");

		ResponseEntity<Iterable<FeedbackInfo>> responseEntity = feedbackService.findAllInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("items", responseEntity.getBody());
		} else {
			modelMap.put("msg", "Server - Get all feedback result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/feedback/index";
	}

	@RequestMapping(value = { "sendMail/{id}" }, method = RequestMethod.GET)
	public String sendMail(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("title", "Manage feedback");
		modelMap.put("feedbackActive", "active");

		modelMap.put("pageTitle", "Reply user's feedback");
		modelMap.put("parentPageTitle", "Feedback");
		
		ResponseEntity<com.demo.models.System> systemResponse = systemService.getSystem();
		if (!(systemResponse == null || systemResponse.getStatusCode() != HttpStatus.OK)) {
			com.demo.models.System system = systemResponse.getBody();
			modelMap.put("defaultSubject", system.getDefaultBanEmailSubject());
			modelMap.put("defaultContent", system.getDefaultBanEmailContent());
			
			ResponseEntity<FeedbackInfo> responseEntity = feedbackService.findInfoById(id);
			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
				FeedbackInfo feedbackInfo = responseEntity.getBody();
				modelMap.put("userId", feedbackInfo.getUserId());
				modelMap.put("content", feedbackInfo.getContent());
				modelMap.put("username", feedbackInfo.getUsername());
			} else {
				modelMap.put("msg", "Server - Get feedback by id result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				modelMap.put("msgType", "danger");
			}
		} else {
			modelMap.put("msg", "Server - Get system info result " + (systemResponse == null ? "null" : systemResponse.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		
		return "manager/feedback/sendMail";
	}

	@RequestMapping(value = { "sendMail" }, method = RequestMethod.POST)
	public String sendMail(@RequestParam("userId") int userId, @RequestParam("subject") String subject,
			@RequestParam("content") String content,
			@RequestParam(value = "isHTMLText", required = false) boolean isHTMLText,
			RedirectAttributes redirectAttr) {
		
		ResponseEntity<com.demo.models.System> systemResponse = systemService.getSystem();
		if (!(systemResponse == null || systemResponse.getStatusCode() != HttpStatus.OK)) {
			com.demo.models.System system = systemResponse.getBody();
			
			ResponseEntity<UserInfo> responseEntity = userService.findInfoById(userId);
			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
				UserInfo user = responseEntity.getBody();

				// send mail
				MailHelper mailHelper = new MailHelper();
				try {
					mailHelper.sendmail(system.getEmail(), system.getEmailPassword(), subject, content, user.getEmail(), isHTMLText);
					redirectAttr.addFlashAttribute("msg", "Send email success!");
					redirectAttr.addFlashAttribute("msgType", "success");
				} catch (Exception e) {
					redirectAttr.addFlashAttribute("msg", "Client - Feedback send mail failed: " + e.getMessage());
					redirectAttr.addFlashAttribute("msgType", "danger");
				}
			} else {
				redirectAttr.addFlashAttribute("msg", "Client - Get feedback result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Get feedback result " + (systemResponse == null ? "null" : systemResponse.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}
		
		return "redirect:/manager/feedback/index";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") FeedbackInfo item, RedirectAttributes redirectAttr) {
		ResponseEntity<FeedbackInfo> responseEntity = feedbackService.create(item);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			redirectAttr.addFlashAttribute("msg", "Update success!");
			redirectAttr.addFlashAttribute("msgType", "success");
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Update feedback result" + (responseEntity == null ? "null"
					: responseEntity.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}

		return "redirect:/manager/feedback/index";
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttr) {
		ResponseEntity<Void> responseEntity = feedbackService.delete(id);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			redirectAttr.addFlashAttribute("msg", "Delete success!");
			redirectAttr.addFlashAttribute("msgType", "success");
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Delete feedback result" + (responseEntity == null ? "null"
					: responseEntity.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}
		return "redirect:/manager/feedback/index";
	}

	@RequestMapping(value = { "toggleStatus/{id}" }, method = RequestMethod.GET)
	public String toggleStatus(@PathVariable("id") int id, RedirectAttributes redirectAttr) {
		ResponseEntity<Void> responseEntity = feedbackService.toggleStatus(id);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			redirectAttr.addFlashAttribute("msg", "Update success!");
			redirectAttr.addFlashAttribute("msgType", "success");
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Update feedback result" + (responseEntity == null ? "null"
					: responseEntity.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}
		return "redirect:/manager/feedback/index";
	}
}