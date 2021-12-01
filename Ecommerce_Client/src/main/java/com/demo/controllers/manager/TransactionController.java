package com.demo.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.models.BranchInfo;
import com.demo.models.TransactionInfo;
import com.demo.services.manager.ITransactionService;

@Controller
@RequestMapping("manager/transaction")
public class TransactionController {

	@Autowired
	private ITransactionService transactionService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("pageTitle", "Transactions");
		modelMap.put("transactionActive", "active");
		
		ResponseEntity<Iterable<TransactionInfo>> responseEntity = transactionService.findAllProductInfo();
		responseEntity = transactionService.findAllProductInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("items", responseEntity.getBody());
		} else {
			modelMap.put("msg", "Server - Get transaction list result " + (responseEntity == null ? "null"
					: responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/transaction/index";
	}
	
	@RequestMapping(value = { "cancel/{id}" }, method = RequestMethod.GET)
	public String cancel(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<TransactionInfo> responseEntity = transactionService.findInfoById(id);
		TransactionInfo result = responseEntity.getBody();
		
		modelMap.put("title", "Edit branch");
		modelMap.put("transactionActive", "active");
		
		modelMap.put("pageTitle", "Cancel transaciton");
		modelMap.put("parentPageTitle", "Transactions");
		
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("id", result.getId());
			modelMap.put("item", result);
		} else {
			modelMap.put("msg", "Server - Get transaction by id result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		
		return "manager/transaction/cancel";
	}
	
	@RequestMapping(value = { "cancel" }, method = RequestMethod.POST)
	public String cancel(@RequestParam("id") int id, @RequestParam("reason") String reason, RedirectAttributes redirectAttr) {
		ResponseEntity<Void> responseEntity = transactionService.updateStatus(id, "cancel", reason);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			redirectAttr.addFlashAttribute("msg", "Cancel success!");
			redirectAttr.addFlashAttribute("msgType", "success");
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Cancel transaction result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}
		
		return "redirect:/manager/transaction/index";
	}
	
	@RequestMapping(value = { "done/{id}" }, method = RequestMethod.GET)
	public String done(@PathVariable("id") int id, RedirectAttributes redirectAttr) {
		ResponseEntity<Void> responseEntity = transactionService.updateStatus(id, "done");
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			redirectAttr.addFlashAttribute("msg", "Update success!");
			redirectAttr.addFlashAttribute("msgType", "success");
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Change transaction status result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}
		
		return "redirect:/manager/transaction/index";
	}
	
	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttr) {
		ResponseEntity<Void> responseEntity = transactionService.delete(id);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			redirectAttr.addFlashAttribute("msg", "Delete success!");
			redirectAttr.addFlashAttribute("msgType", "success");
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Delete transaction result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}
		
		return "redirect:/manager/transaction/index";
	}

}