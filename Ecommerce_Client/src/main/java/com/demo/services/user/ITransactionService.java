  package com.demo.services.user;

import org.springframework.http.ResponseEntity;

import com.demo.models.TransactionInfo;

public interface ITransactionService {

	ResponseEntity<Iterable<TransactionInfo>> findAllByUserId(int userId);
	
	ResponseEntity<TransactionInfo> create(TransactionInfo _object);
	
}
