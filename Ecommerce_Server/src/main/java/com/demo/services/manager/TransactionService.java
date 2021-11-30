package com.demo.services.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Tags;
import com.demo.models.TagInfo;
import com.demo.models.TransactionInfo;
import com.demo.repositories.manager.ITagRepository;
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
}
