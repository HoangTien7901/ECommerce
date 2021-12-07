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

import com.demo.entities.Transactions;
import com.demo.models.TransactionInfo;
import com.demo.services.user.ITransactionService;

@RestController
@RequestMapping(value = {"api/transaction"})
public class U_TransactionRestController {
	
	@Autowired
	private ITransactionService transactionService;
	
	@RequestMapping(value = "findAllByUserId/{userId}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<TransactionInfo>> findInfoById(@PathVariable("userId") int userId){
		try {
			return new ResponseEntity<Iterable<TransactionInfo>>(transactionService.findAllInfoByUserId(userId), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Iterable<TransactionInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"create"} , method = RequestMethod.POST,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> create(@RequestBody TransactionInfo _object) {
		try {
			Transactions transaction = transactionService.create(_object);
			if (transaction == null) {
				throw new Exception("Created transaction equals null.");
			}
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Server error create transaction: " + e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
