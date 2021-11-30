package com.demo.controllers.manager;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.TransactionInfo;
import com.demo.services.manager.ITransactionService;

@Controller
@RequestMapping("manager/transaction")
public class TransactionController {

	@Autowired
	private ITransactionService transactionService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<Iterable<TransactionInfo>> responseEntity = transactionService.findAllServiceInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
				modelMap.put("title", "Service transaction list");
				modelMap.put("transactionActive", "active");
				modelMap.put("adminOpen", true);
				
				modelMap.put("services", responseEntity.getBody());
				modelMap.put("pageTitle1", "Service transaction list");
		} else {
			System.out.println("Client - Get transaction list (services) error : " + responseEntity == null ? "null" : responseEntity.getStatusCode());
		}
		
		responseEntity = transactionService.findAllProductInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
				modelMap.put("products", responseEntity.getBody());
				modelMap.put("pageTitle2", "Product transaction list");
		} else {
			System.out.println("Client - Get transaction list (products) error : " + responseEntity == null ? "null" : responseEntity.getStatusCode());
		}
		return "manager/transaction/index";
	}

}