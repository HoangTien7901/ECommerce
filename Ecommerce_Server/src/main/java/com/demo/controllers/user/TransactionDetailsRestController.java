package com.demo.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.TransactionDetails;
import com.demo.entities.Transactions;
import com.demo.models.TransactionDetailsInfo;
import com.demo.models.TransactionInfo;
import com.demo.services.user.ITransactionDetailsService;
import com.demo.services.user.ITransactionService;

@RestController
@RequestMapping(value = {"api/transactionDetails"})
public class TransactionDetailsRestController {
	
	@Autowired
	private ITransactionDetailsService service;
	
	@RequestMapping(value= {"create"} , method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionDetailsInfo> create(@RequestBody TransactionDetailsInfo _object) {
		try {
			return new ResponseEntity<TransactionDetailsInfo>(service.create(_object), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Server error create transaction: " + e.getMessage());
			return new ResponseEntity<TransactionDetailsInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
