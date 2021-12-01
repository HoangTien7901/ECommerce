package com.demo.controllers.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.helpers.MailHelper;
import com.demo.models.UserInfo;
import com.demo.services.manager.ISystemService;
import com.demo.services.manager.IUserService;

@Controller
@RequestMapping("manager/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private ISystemService systemService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("title", "Manage user");
		modelMap.put("userActive", "active");

		modelMap.put("pageTitle", "User list");
		modelMap.put("parentPageTitle", "User");

		ResponseEntity<Iterable<UserInfo>> responseEntity = userService.findAllInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("items", responseEntity.getBody());
		} else {
			modelMap.put("msg", "Server - Get all users result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/user/index";
	}

	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {

		modelMap.put("title", "Edit user");
		modelMap.put("userActive", "active");

		modelMap.put("pageTitle", "Edit");
		modelMap.put("parentPageTitle", "User");

		ResponseEntity<UserInfo> responseEntity = userService.findInfoById(id);
		UserInfo result = responseEntity.getBody();

		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("date", formater.format(result.getBirthday()));
			modelMap.put("item", result);
		} else {
			modelMap.put("msg", "Server - Get user by id result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/user/edit";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") @Valid UserInfo item, BindingResult errors, ModelMap modelMap,
			@RequestParam("birthday") String _birthday, RedirectAttributes redirectAttr) {

		if (errors.hasErrors()) {
			SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

			modelMap.put("date", formater.format(item.getBirthday()));

			modelMap.put("title", "Edit user");
			modelMap.put("userActive", "active");

			modelMap.put("pageTitle", "Edit");
			modelMap.put("parentPageTitle", "User");

			return "manager/user/edit";
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

			return "redirect:/manager/user/index";
		}
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttr) {
		ResponseEntity<Void> responseEntity = userService.delete(id);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			redirectAttr.addFlashAttribute("msg", "Delete success!");
			redirectAttr.addFlashAttribute("msgType", "success");
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Delete user result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}
		return "redirect:/manager/user/index";
	}

	@RequestMapping(value = { "ban/{id}" }, method = RequestMethod.GET)
	public String ban(@PathVariable("id") int id, ModelMap modelMap) {

		modelMap.put("title", "Ban user");
		modelMap.put("userActive", "active");

		modelMap.put("pageTitle", "Ban");
		modelMap.put("parentPageTitle", "User");

		ResponseEntity<UserInfo> responseEntity = userService.findInfoById(id);
		UserInfo result = responseEntity.getBody();

		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("id", result.getId());
			modelMap.put("username", result.getUsername());
		} else {
			modelMap.put("msg", "Server - Get user by id result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/user/ban";
	}

	@RequestMapping(value = { "ban" }, method = RequestMethod.POST)
	public String ban(@RequestParam("id") int id, @RequestParam("subject") String subject,
			@RequestParam("banDuration") int banDuration, @RequestParam("content") String content,
			@RequestParam(value = "isHTMLText", required = false) boolean isHTMLText, RedirectAttributes redirectAttr) {

		ResponseEntity<com.demo.models.System> systemResponse = systemService.getSystem();
		if (!(systemResponse == null || systemResponse.getStatusCode() != HttpStatus.OK)) {
			com.demo.models.System system = systemResponse.getBody();

			ResponseEntity<UserInfo> userResponse = userService.findInfoById(id);
			String recipient = "";
			if (!(userResponse == null || userResponse.getStatusCode() != HttpStatus.OK)) {
				recipient = userResponse.getBody().getEmail();

				Date today = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(today);
				calendar.add(Calendar.MONTH, banDuration);
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

				ResponseEntity<Void> responseEntity = userService.updateBanTerm(id,
						formater.format(calendar.getTime()));
				if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {

					// send mail
					MailHelper mailHelper = new MailHelper();
					try {
						mailHelper.sendmail(system.getEmail(), system.getEmailPassword(), subject, content, recipient,
								isHTMLText);
					} catch (Exception e) {
						redirectAttr.addFlashAttribute("msg", "Client user send mail failed: " + e.getMessage());
						redirectAttr.addFlashAttribute("msgType", "danger");
					}
				} else {
					redirectAttr.addFlashAttribute("msg", "Server - Get user ban term result "
							+ (userResponse == null ? "null" : userResponse.getStatusCode()));
					redirectAttr.addFlashAttribute("msgType", "danger");
				}

				responseEntity = userService.toggleStatus(id);
				if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
					redirectAttr.addFlashAttribute("msg", "Ban success!");
					redirectAttr.addFlashAttribute("msgType", "success");
				} else {
					redirectAttr.addFlashAttribute("msg", "Server - Change user status result "
							+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
					redirectAttr.addFlashAttribute("msgType", "danger");
				}
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Get user by id result "
						+ (userResponse == null ? "null" : userResponse.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Get system info result "
					+ (systemResponse == null ? "null" : systemResponse.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}

		return "redirect:/manager/user/index";
	}

	@RequestMapping(value = { "toggleStatus/{id}" }, method = RequestMethod.GET)
	public String toggleStatus(@PathVariable("id") int id, RedirectAttributes redirectAttr) {
		ResponseEntity<Void> responseEntity = userService.toggleStatus(id);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			// just send some temporary text to make it not null
			responseEntity = userService.updateBanTerm(id, "tmp");

			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {

			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Update user's ban term status result "
						+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Toggle user status result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}
		return "redirect:/manager/user/index";
	}
}