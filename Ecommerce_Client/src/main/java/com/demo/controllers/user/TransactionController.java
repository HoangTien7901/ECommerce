package com.demo.controllers.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.models.TransactionInfo;
import com.demo.services.BranchService;
import com.demo.services.TransactionService;

@Controller
@RequestMapping(value = {"transaction" })
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private BranchService branchService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "store/transaction/index2";
	}
	
	@RequestMapping(value = "findAllOrder", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<TransactionInfo> findAllOrder() {
 
		ResponseEntity<List<TransactionInfo>> responseEntity = transactionService.findAllOrder();
 
		return responseEntity.getBody();
	}
	
	@RequestMapping(value = "findAllService", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<TransactionInfo> findAllService() {
 
		ResponseEntity<List<TransactionInfo>> responseEntity = transactionService.findAllService();
 
		return responseEntity.getBody();
	}
	
	@RequestMapping(value = "create", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody TransactionInfo create(@ModelAttribute("transaction") @Valid TransactionInfo transaction, BindingResult errors ) {
 
		/*
		 * employeeValidator.validate(employee, errors); if(errors.hasErrors()) { return
		 * "employee/register"; }else { return "employee/success"; }
		 */
		//ResponseEntity<TransactionInfo> responseEntity = transactionService.findAll();
		
		return new TransactionInfo();
	}
	

}
