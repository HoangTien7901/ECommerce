package com.demo.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Contacts;
import com.demo.services.user.ContactService;

@Controller
@RequestMapping(value = "contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index() {
		return "user/contact/index";
	}
	
	@RequestMapping(value = {"save"}, method = RequestMethod.POST)
	public String save(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		
		try {
			Contacts contact = new Contacts(name, email, phone, address, true);
			contactService.save(contact);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "user/contact/index";
		
	}
}
