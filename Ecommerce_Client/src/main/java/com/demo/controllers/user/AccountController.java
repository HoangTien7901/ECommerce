package com.demo.controllers.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.helpers.MailHelper;
import com.demo.helpers.PasswordGenerator;
import com.demo.models.BannerInfo;
import com.demo.models.UserInfo;
import com.demo.services.manager.ISystemService;
import com.demo.services.manager.UserService;
import com.demo.services.user.IUserService;
import com.demo.validators.UserValidator;

@Controller
@RequestMapping(value = {"user/account"})
public class AccountController {

	@Autowired
	private IUserService service;
	
	@Autowired
	private ISystemService systemService;
	
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value = {"login" }, method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		return "user/account/login";
	}
	
	@RequestMapping(value = {"login" }, method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, 
			RedirectAttributes redirectAttr, ModelMap modelMap) {
		
		ResponseEntity<UserInfo> responseEntity = service.findInfoByUsername(username);
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
			
			UserInfo user = responseEntity.getBody();
			
			if (BCrypt.checkpw(password, user.getPassword())) {
				redirectAttr.addFlashAttribute("msg", "Login success!");
				redirectAttr.addFlashAttribute("msgType", "success");
				
				return "redirect:/user/home/index";
			} else {
				modelMap.put("msg", "Invalid username or password.");
				modelMap.put("msgType", "danger");
				
				return "user/account/login";
			}
		} else {
			if (responseEntity == null) {
				modelMap.put("msg", "Can't find any user with username " + username);
			} else {
				modelMap.put("msg", "Find user by username result " + responseEntity.getStatusCode());
			}
			
			modelMap.put("msgType", "danger");
			
			return "redirect:/user/home/index";
		}
	}
	
	@RequestMapping(value = {"register" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		UserInfo user = new UserInfo();
		user.setPassword("TemporaryPasswordString@1");
		modelMap.put("item", user);
		
		return "user/account/register";
	}
	
	@RequestMapping(value = {"register" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("item") @Valid UserInfo _object, 
			BindingResult errors, @RequestParam("birthday") String _birthday,
			RedirectAttributes redirectAttr, ModelMap modelMap) {
		userValidator.validate(_object, errors);
		if (errors.hasErrors()) {
			return "user/account/register";
		} else {
			ResponseEntity<com.demo.models.System> systemResponse = systemService.getSystem();
			if (!(systemResponse == null || systemResponse.getStatusCode() != HttpStatus.OK)) {
				
				// set birthday
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				formater.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
				Date birthday = new Date();
				try {
					birthday = formater.parse(_birthday);
				} catch (ParseException e) {
					redirectAttr.addFlashAttribute("msg", "Client parse birthday error: " + e.getMessage());
					redirectAttr.addFlashAttribute("msgType", "danger");
				}
				_object.setBirthday(birthday);
				
				// generate a random password
				PasswordGenerator passGenerator = new PasswordGenerator();
				String password = passGenerator.generateRndPassword();
				System.out.print("password : " + password);
				_object.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
				
				// send password to user email
				com.demo.models.System system = systemResponse.getBody();
				MailHelper mailHelper = new MailHelper();
				try {
					mailHelper.sendmail(system.getEmail(), system.getEmailPassword(), "Your password for our website", password, _object.getEmail(), false);
					
					// create user
					ResponseEntity<UserInfo> responseEntity = service.create(_object);
					if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
						UserInfo user = responseEntity.getBody();
						// set session here
						
						redirectAttr.addFlashAttribute("msg", "Sign up success!");
						redirectAttr.addFlashAttribute("msgType", "success");
						
						return "redirect:/user/home/index";
					} else {
						modelMap.put("msg", "Server - Create user result "
								+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
						modelMap.put("msgType", "danger");
						
						return "user/account/register";
					}
				} catch (Exception e) {
					modelMap.put("msg", "Error sending mail to email " + _object.getEmail() + ": " + e.getMessage());
					modelMap.put("msgType", "danger");
					
					return "user/account/register";
				}
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Get system info result "
						+ (systemResponse == null ? "null" : systemResponse.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
				
				return "redirect:/user/home/index";
			}
		}
	}
	
}
