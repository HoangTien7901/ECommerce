package com.demo.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "account" )
public class AccountController {
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,
		ModelMap modelMap) {
		if(error != null) {
			modelMap.put("msg", "invalid");
		}
		if(logout != null) {
			modelMap.put("msg", "Logout");
		}
		return "account/login";
	}
}
