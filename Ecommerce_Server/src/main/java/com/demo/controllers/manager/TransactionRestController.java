package com.demo.controllers.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.TransactionInfo;
import com.demo.services.manager.ITransactionService;

@RestController
@RequestMapping("api/manager/transaction")
public class TransactionRestController {
	
	@Autowired
	private ITransactionService service;
	
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<TransactionInfo>> findAllInfo() {
		try {
			Iterable<TransactionInfo> result = service.findAllInfo();
			
			return new ResponseEntity<Iterable<TransactionInfo>>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<TransactionInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findAllService", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<TransactionInfo>> findAllIServiceInfo() {
		try {
			Iterable<TransactionInfo> result = service.findAllServiceInfo();
			
			return new ResponseEntity<Iterable<TransactionInfo>>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<TransactionInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findAllProduct", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<TransactionInfo>> findAllProductInfo() {
		try {
			Iterable<TransactionInfo> result = service.findAllProductInfo();
			
			return new ResponseEntity<Iterable<TransactionInfo>>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<TransactionInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
