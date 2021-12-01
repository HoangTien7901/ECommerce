package com.demo.services.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Transactions;
import com.demo.models.TransactionInfo;
import com.demo.repositories.manager.ITransactionRepository;

@Service("transaction")
public class TransactionService implements ITransactionService {

	@Autowired
	private ITransactionRepository repos;

	@Override
	public Iterable<TransactionInfo> findAllInfo() {
		return repos.findAllInfo();
	}

	@Override
	public Iterable<TransactionInfo> findAllServiceInfo() {
		return repos.findAllServiceInfo();
	}
	
	@Override
	public Iterable<TransactionInfo> findAllProductInfo() {
		return repos.findAllProductInfo();
	}

	@Override
	public TransactionInfo findInfoById(int id) {
		return repos.findInfoById(id);
	}

	@Override
	public Transactions findById(int id) {
		return repos.findById(id).get();
	}
	
	@Override
	public int updateStatus(int id, String _status) {
		return repos.updateStatus(id, _status);
	}
	
	@Override
	public int updateStatus(int id, String _status, String reason) {
		return repos.updateStatus(id, _status, reason);
	}

	@Override
	public void delete(int id) {
		repos.delete(repos.findById(id).get());
	}
}
