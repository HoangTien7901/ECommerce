package com.demo.services.manager;

import com.demo.models.TransactionInfo;

public interface ITransactionService {

	public Iterable<TransactionInfo> findAllInfo();
	
	public Iterable<TransactionInfo> findAllServiceInfo();
	
	public Iterable<TransactionInfo> findAllProductInfo();
}
