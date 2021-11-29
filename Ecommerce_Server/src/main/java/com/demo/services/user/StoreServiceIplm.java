package com.demo.services.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Stores;
import com.demo.models.StoreInfo;
import com.demo.repositories.user.StoreRepository;

@Service("storeService")
public class StoreServiceIplm implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Iterable<StoreInfo> findAll() {
		return storeRepository.getList();
	}

	@Override
	public StoreInfo find(int id) {
		return storeRepository.find(id);
	}

	@Override
	public Stores findById(int id) {
		return storeRepository.findById(id).get();
	}

	@Override
	public Stores save(Stores store) {
		return storeRepository.save(store);
	}

}
