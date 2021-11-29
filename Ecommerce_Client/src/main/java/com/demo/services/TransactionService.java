package com.demo.services;
import java.util.List;

import org.springframework.http.ResponseEntity;
import com.demo.models.TransactionInfo;

public interface TransactionService {
	
	public ResponseEntity<List<TransactionInfo>> findAllOrder();
	
	public ResponseEntity<List<TransactionInfo>> findAllService();
	
	public ResponseEntity<TransactionInfo> save(TransactionInfo transaction);
	
}
