package com.demo.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "login")
public class LoginController {
	
	@RequestMapping(value = {"", "index"} , method = RequestMethod.GET)
	public String index() {
		
		return "user/login/index";

	}
	@RequestMapping(value = {"", "index2"} , method = RequestMethod.GET)
	public String index2() {
		
		return "user/login/index2";

	}
}
