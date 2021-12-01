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
@RequestMapping("manager/sales")
public class SalesController {

	@Autowired
	private ITransactionService transactionService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("pageTitle2", "Product transaction list");
		modelMap.put("adminOpen", true);
		modelMap.put("salesActive", "active");
		
		ResponseEntity<Iterable<TransactionInfo>> responseEntity = transactionService.findAllServiceInfo();
		responseEntity = transactionService.findAllProductInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("products", responseEntity.getBody());
		} else {
			modelMap.put("msg", "Server - Get transaction list result " + (responseEntity == null ? "null"
					: responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/sales/index";
	}

}