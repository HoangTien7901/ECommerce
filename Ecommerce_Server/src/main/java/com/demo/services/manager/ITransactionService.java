package com.demo.services.manager;

import com.demo.entities.Transactions;
import com.demo.models.TransactionInfo;

public interface ITransactionService {

	public Iterable<TransactionInfo> findAllInfo();
	
	public Iterable<TransactionInfo> findAllServiceInfo();
	
	public Iterable<TransactionInfo> findAllProductInfo();
	
	public TransactionInfo findInfoById(int id);
	
	public Transactions findById(int id);
	
	public int updateStatus(int id, String _status);
	
	public int updateStatus(int id, String _status, String reason);
	
	public void delete(int id);
}
