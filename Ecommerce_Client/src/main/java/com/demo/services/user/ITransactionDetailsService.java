  package com.demo.services.user;

import org.springframework.http.ResponseEntity;

import com.demo.models.TransactionDetailsInfo;

public interface ITransactionDetailsService {

	ResponseEntity<TransactionDetailsInfo> create(TransactionDetailsInfo _object);
	
}
