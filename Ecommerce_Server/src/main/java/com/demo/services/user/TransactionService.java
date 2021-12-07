package com.demo.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Products;
import com.demo.entities.Stores;
import com.demo.entities.TransactionDetails;
import com.demo.entities.Transactions;
import com.demo.models.CartInfo;
import com.demo.models.TransactionInfo;
import com.demo.repositories.manager.IProductRepository;
import com.demo.repositories.manager.IStoreRepository;
import com.demo.repositories.user.ITransactionDetailsRepository;
import com.demo.repositories.user.ITransactionRepository;

@Service("userTransaction")
public class TransactionService implements ITransactionService {

	@Autowired
	private ITransactionRepository repos;

	@Autowired
	private IStoreRepository storeRepos;
	
	@Autowired
	private IProductRepository productRepos;
	
	@Autowired
	private ITransactionDetailsRepository detailsRepos;
	
	@Override
	public Iterable<TransactionInfo> findAllInfoByUserId(int userId) {
		return repos.findAllInfoByUserId(userId);
	}

	@Override
	public Transactions create(TransactionInfo _object) {
		Transactions object = new Transactions();
		object.setPrice(_object.getPrice());
		
		Products product = productRepos.findById(_object.getProductId()).get();
		object.setProducts(product);
		
		Stores store = storeRepos.findById(1).get();
		object.setStores(store);
		
		object.setQuantity(_object.getQuantity());
		object.setStatus("pending");
		object.setPrice(product.getPrice());
		object.setTotal(_object.getQuantity() * product.getPrice());
		
		productRepos.updateQuantity(product.getId(), product.getQuantity() - object.getQuantity());
		
		TransactionDetails details = detailsRepos.findById(_object.getTransactionDetailsId()).get();
		object.setTransactionDetails(details);
		
		return repos.save(object);
	}
	
}
