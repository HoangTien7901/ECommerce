package com.demo.controllers.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.services.user.CartsSerivce;
import com.demo.entities.Carts;
import com.demo.models.CartsInfor;

@Controller
@RequestMapping(value = "cart")
public class CartController {

	@Autowired
	private CartsSerivce cartsSerivce;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<List<CartsInfor>> responseEntity = cartsSerivce.findAll();
		if (responseEntity != null) {
			System.out.println("Status : " + responseEntity.getStatusCodeValue());
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				List<CartsInfor> findall = (List<CartsInfor>) responseEntity.getBody();
				System.out.println("Result : " + findall.size());

				modelMap.put("cartall", findall);
			}
		}
		return "user/cart/index";

	}

	
	@RequestMapping(value = {"add/{id}/{price}/{quantity}/{user}"}, method = RequestMethod.GET)
	public String addById(ModelMap model, @PathVariable("id") int id, @PathVariable("price") double price,
			@PathVariable("quantity") int quantity, @PathVariable("user") int user) {

		Date date = new Date();
		Carts carts = new Carts();
		carts.setCreated(date);
		carts.setPrice(price);
		carts.setProductsId(id);
		carts.setQuantity(quantity);
		carts.setUsersId(user);

		ResponseEntity<Carts> responseEntity = cartsSerivce.create(carts);
		if (responseEntity != null) {
			System.out.println("status: " + responseEntity.getStatusCodeValue());
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				System.out.println("========");
				carts = responseEntity.getBody();
				System.out.println(carts);
				model.put("msg", "Done");
			}
		}else {
			
		}
		
		return "user/cart/index";
	}
	
	
}
