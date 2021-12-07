package com.demo.services.user;

import com.demo.entities.Transactions;
import com.demo.models.TransactionInfo;

public interface ITransactionService {

	public Iterable<TransactionInfo> findAllInfoByUserId(int userId);

	public Transactions create(TransactionInfo _object);
	
}
