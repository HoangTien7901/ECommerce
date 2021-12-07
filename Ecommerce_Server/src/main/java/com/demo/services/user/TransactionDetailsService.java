package com.demo.services.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.TransactionDetails;
import com.demo.entities.Transactions;
import com.demo.entities.Users;
import com.demo.models.CartInfo;
import com.demo.models.TransactionDetailsInfo;
import com.demo.models.TransactionInfo;
import com.demo.repositories.manager.IUserRepository;
import com.demo.repositories.user.ITransactionDetailsRepository;
import com.demo.repositories.user.ITransactionRepository;

@Service("userTransactionDetails")
public class TransactionDetailsService implements ITransactionDetailsService {

	@Autowired
	private ITransactionDetailsRepository repos;

	@Autowired
	private IUserRepository userRepos;
	
	@Override
	public TransactionDetailsInfo create(TransactionDetailsInfo _object) {
		TransactionDetails object = new TransactionDetails();
		object.setName(_object.getName());
		object.setCreated(new Date());
		object.setQuantity(_object.getQuantity());
		
		Users user = userRepos.findById(_object.getUserId()).get();
		object.setUsers(user);
		
		// create address field for user
//		object.setAddress(user.getAddress());
		
		object.setAddress("tmp address");
		
		object = repos.save(object);
				
		return repos.findInfoById(object.getId());
	}

}
