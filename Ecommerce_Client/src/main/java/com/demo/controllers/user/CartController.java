package com.demo.controllers.user;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.services.user.CartsSerivce;
import com.demo.services.user.ProductsService;

@Controller
@RequestMapping(value = "cart")
public class CartController {

	@Autowired
	private CartsSerivce cartsSerivce;

	@Autowired
	private ProductsService productsService;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index() {

		return "user/cart/index";

	}

	@RequestMapping(value = { "buy/{id}" }, method = RequestMethod.GET)
	public String buy(@PathVariable("id") int id, ModelMap modelMap, HttpSession session) {
	

		return "user/cart/index";

	}


}
