package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.models.TransactionInfo;

public interface ITransactionService {

	public ResponseEntity<Iterable<TransactionInfo>> findAllInfo();
	
	public ResponseEntity<Iterable<TransactionInfo>> findAllServiceInfo();
	
	public ResponseEntity<Iterable<TransactionInfo>> findAllProductInfo();
}
