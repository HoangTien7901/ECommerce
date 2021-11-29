package com.demo.services.user;

import com.demo.entities.Transactions;
import com.demo.models.TransactionInfo;

public interface TransactionService {
	
	public Iterable<TransactionInfo> findAllOrder();
	
	public Iterable<TransactionInfo> findAllService();
	
	public Transactions save(Transactions transaction);
	
	public Transactions findById(int id);
	
	/*
	 * public boolean delete(int id);
	 * 
	 * public boolean delete(List<Integer> ids);
	 * 
	 * public Products create(Products product);
	 */
}
