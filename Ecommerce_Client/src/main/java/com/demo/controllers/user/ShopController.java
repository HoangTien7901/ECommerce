package com.demo.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "shop")
public class ShopController {
	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index() {
		
		return "user/shop/index";

	}
}
