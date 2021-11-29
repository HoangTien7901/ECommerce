package com.demo.controllers.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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
import com.demo.models.UserInfo;
import com.demo.services.manager.IUserService;

@Controller
@RequestMapping("manager/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<Iterable<UserInfo>> responseEntity = userService.findAllInfo();
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("title", "Manage user");
				modelMap.put("userActive", "active");

				modelMap.put("items", responseEntity.getBody());
				modelMap.put("pageTitle", "User list");
				modelMap.put("parentPageTitle", "User");
			}
		}
		return "manager/user/index";
	}

	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<UserInfo> responseEntity = userService.findInfoById(id);
		UserInfo result = responseEntity.getBody();

		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("date", formater.format(result.getBirthday()));
				
				modelMap.put("title", "Edit user");
				modelMap.put("userActive", "active");

				modelMap.put("item", result);
				modelMap.put("pageTitle", "Edit");
				modelMap.put("parentPageTitle", "User");
			}
		}
		return "manager/user/edit";
	}
	
	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") UserInfo item, @RequestParam("birthday") String _birthday) {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		formater.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
		Date birthday = new Date();
		
		try {
			birthday = formater.parse(_birthday);
			System.out.println("Client user parse date 1: " + birthday.toString());
		} catch (ParseException e) {
			System.out.println("Client user parse date error: " + e.getMessage());
			e.printStackTrace();
		}
		
		item.setBirthday(birthday);
		
		ResponseEntity<Void> responseEntity = userService.update(item);
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
//			UserInfo result = responseEntity.getBody();

		} else {
			System.out.println(
					"Client - Update user result" + responseEntity == null ? "null" : responseEntity.getStatusCode());
		}

		return "redirect:/manager/user/index";
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		ResponseEntity<Void> responseEntity = userService.delete(id);
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {

			} else {

			}
		}
		return "redirect:/manager/user/index";
	}
	
	@RequestMapping(value = { "ban/{id}" }, method = RequestMethod.GET)
	public String ban(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<UserInfo> responseEntity = userService.findInfoById(id);
		UserInfo result = responseEntity.getBody();

		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("id", result.getId());
				modelMap.put("username", result.getUsername());
				
				modelMap.put("title", "Ban user");
				modelMap.put("userActive", "active");

				modelMap.put("pageTitle", "Ban");
				modelMap.put("parentPageTitle", "User");
			}
		}
		return "manager/user/ban";
	}
	
	@RequestMapping(value = { "ban" }, method = RequestMethod.POST)
	public String ban(@RequestParam("id") int id, @RequestParam("subject") String subject, @RequestParam("banDuration") int banDuration,
			@RequestParam("content") String content, @RequestParam(value = "isHTMLText", required = false) boolean isHTMLText) {
		ResponseEntity<UserInfo> userResponseEntity = userService.findInfoById(id);
		String recipient = "";
		if (userResponseEntity != null && userResponseEntity.getStatusCode() == HttpStatus.OK) {
			recipient = userResponseEntity.getBody().getEmail();
			
			Date today = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(today);
			calendar.add(Calendar.MONTH, banDuration);
			SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
			
			ResponseEntity<Void> responseEntity = userService.updateBanTerm(id, formater.format(calendar.getTime()));
			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
				
				// send mail
				MailHelper mailHelper = new MailHelper();
				try {
//					mailHelper.sendmail("<email here>", "<password here>", subject, content, recipient, isHTMLText);
				} catch (Exception e) {
					System.out.println("Client user send mail failed: " + e.getMessage());
				}
			} else {
				System.out.println("Client user update ban term failed: " + responseEntity == null ? "null" : responseEntity.getStatusCode());
			}
			
			responseEntity = userService.toggleStatus(id);
			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
				
			} else {
				System.out.println("Client change user status failed : " + responseEntity == null ? "null" : responseEntity.getStatusCode());
			}
		} else {
			System.out.println("Client user get user by id failed: " + userResponseEntity == null ? "null" : userResponseEntity.getStatusCode());
		}
		
		return "redirect:/manager/user/index";
	}

	@RequestMapping(value = { "toggleStatus/{id}" }, method = RequestMethod.GET)
	public String toggleStatus(@PathVariable("id") int id) {
		ResponseEntity<Void> responseEntity = userService.toggleStatus(id);
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				// just send some temporary text to make it not null
				responseEntity = userService.updateBanTerm(id, "tmp");
				
				if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
					
				} else {
					System.out.println("Client - Toggle user status result" + responseEntity == null ? "null"
							: responseEntity.getStatusCode());
				}
			} else {

			}
		}
		return "redirect:/manager/user/index";
	}
}