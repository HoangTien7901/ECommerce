package com.demo.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Transactions;
import com.demo.models.TransactionInfo;
import com.demo.repositories.user.TransactionRepository;

@Service("transactionService")
public class TransactionServiceIplm implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Iterable<TransactionInfo> findAllOrder() {
		return transactionRepository.getListOrder();
	}	
	
	@Override
	public Iterable<TransactionInfo> findAllService() {
		return transactionRepository.getListService();
	}

	@Override
	public Transactions save(Transactions transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Transactions findById(int id) {
		return transactionRepository.findById(id).get();
	}	

}
