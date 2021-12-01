package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.models.TransactionInfo;

public interface ITransactionService {

	public ResponseEntity<Iterable<TransactionInfo>> findAllInfo();
	
	public ResponseEntity<Iterable<TransactionInfo>> findAllServiceInfo();
	
	public ResponseEntity<Iterable<TransactionInfo>> findAllProductInfo();
	
	public ResponseEntity<TransactionInfo> findInfoById(int id);
	
	public ResponseEntity<Void> updateStatus(int id, String status);
	
	public ResponseEntity<Void> updateStatus(int id, String status, String reason);
	
	public ResponseEntity<Void> delete(int id);
}
