package com.demo.controllers.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.models.UserInfo;
import com.demo.services.manager.IUserService;

@Controller
@RequestMapping("manager/profile")
public class ProfileController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String edit(ModelMap modelMap) {

		modelMap.put("title", "Admin profile");
		modelMap.put("profileActive", "active");

		modelMap.put("pageTitle", "Profile");
		modelMap.put("parentPageTitle", "Admin");

		ResponseEntity<UserInfo> responseEntity = userService.findInfoById(1);
		UserInfo result = responseEntity.getBody();

		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("date", formater.format(result.getBirthday()));
			modelMap.put("item", result);
		} else {
			modelMap.put("msg", "Server - Get profile by id result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/profile/index";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") @Valid UserInfo item, BindingResult errors, ModelMap modelMap,
			@RequestParam("birthday") String _birthday, RedirectAttributes redirectAttr) {

		if (errors.hasErrors()) {
			SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

			modelMap.put("date", formater.format(item.getBirthday()));

			modelMap.put("title", "Admin profile");
			modelMap.put("profileActive", "active");

			modelMap.put("pageTitle", "Profile");
			modelMap.put("parentPageTitle", "Admin");

			return "manager/profile/index";
		} else {
			SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
			formater.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
			Date birthday = new Date();

			try {
				birthday = formater.parse(_birthday);
			} catch (ParseException e) {
				redirectAttr.addFlashAttribute("msg", "Client user parse date error: " + e.getMessage());
				redirectAttr.addFlashAttribute("msgType", "danger");
			}

			item.setBirthday(birthday);

			ResponseEntity<Void> responseEntity = userService.update(item);
			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
				redirectAttr.addFlashAttribute("msg", "Update success!");
				redirectAttr.addFlashAttribute("msgType", "success");
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Update user result "
						+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}

			return "redirect:/manager/profile/index";
		}
	}

	@RequestMapping(value = { "changePassword" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("oldPassword") String oldPassword, @ModelAttribute("newPassword") String password, ModelMap modelMap,
			RedirectAttributes redirectAttr) {

		ResponseEntity<UserInfo> responseEntity = userService.findInfoById(1);
		UserInfo result = responseEntity.getBody();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			
			if (BCrypt.checkpw(oldPassword, result.getPassword())) {
				
				String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
				result.setPassword(pw_hash);
				
				ResponseEntity<Void> responseEntity2 = userService.update(result);
				if (responseEntity2 != null && responseEntity2.getStatusCode() == HttpStatus.OK) {
					redirectAttr.addFlashAttribute("msg", "Change password success!");
					redirectAttr.addFlashAttribute("msgType", "success");
				} else {
					redirectAttr.addFlashAttribute("msg", "Server - Change password result "
							+ (responseEntity2 == null ? "null" : responseEntity2.getStatusCode()));
					redirectAttr.addFlashAttribute("msgType", "danger");
				}
			} else {
				redirectAttr.addFlashAttribute("msg", "Invalid old password.");
				redirectAttr.addFlashAttribute("msgType", "danger");
			}
		} else {
			modelMap.put("msg", "Server - Get profile by id result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}		

		return "redirect:/manager/profile/index";
	}

}