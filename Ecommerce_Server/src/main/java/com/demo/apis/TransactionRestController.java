package com.demo.apis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Transactions;
import com.demo.models.ProductInfo;
import com.demo.models.TransactionInfo;
import com.demo.services.user.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionRestController {

	@Autowired
	private TransactionService transactionService;

	@RequestMapping(value = "findall/order", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<TransactionInfo>> findAllOrder() {
		try {
			return new ResponseEntity<Iterable<TransactionInfo>>(transactionService.findAllOrder(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Iterable<TransactionInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findall/service", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<TransactionInfo>> findAllService() {
		try {
			return new ResponseEntity<Iterable<TransactionInfo>>(transactionService.findAllService(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Iterable<TransactionInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transactions> update(@RequestBody TransactionInfo info) {
		try {
			Transactions transaction = transactionService.findById(info.getId());
			transaction.setStatus(info.isStatus());			
			return new ResponseEntity<Transactions>(transactionService.save(transaction), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Transactions>(HttpStatus.BAD_REQUEST);
		}
	}

}
