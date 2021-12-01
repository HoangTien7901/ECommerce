package com.demo.controllers.manager;

import java.util.regex.PatternSyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "findInfoById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionInfo> findInfoById(@PathVariable("id") int id) {
		try {
			TransactionInfo result = service.findInfoById(id);
			
			return new ResponseEntity<TransactionInfo>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<TransactionInfo>(HttpStatus.BAD_REQUEST);
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
	
	@RequestMapping(value= {"updateStatus/{id}"} , method = RequestMethod.PUT,
			consumes = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody String _string) {
		try {
			int result = 0;
			String string = _string.trim();
			String[] strings = new String[2];
			
			if (string.charAt(string.length() - 1) ==  '-') {
				result = service.updateStatus(id, string.substring(0, string.length() - 1) , "");
			} else {
				strings = string.split("-");
				
				String cancelReason = "Cancelled by store - " + strings[1];
				result = service.updateStatus(id, strings[0], cancelReason);
			}
			
			if (result == 1) {
				return new ResponseEntity<Void>(HttpStatus.OK);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"delete/{id}"} , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		try {
			service.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
