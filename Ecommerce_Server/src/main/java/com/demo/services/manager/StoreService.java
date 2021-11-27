package com.demo.services.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Stores;
import com.demo.entities.Users;
import com.demo.models.StoreInfo;
import com.demo.repositories.manager.IStoreRepository;
import com.demo.repositories.manager.IUserRepository;

@Service("store")
public class StoreService implements IStoreService {

	@Autowired
	private IStoreRepository storeRepos;
	
	@Autowired
	private IUserRepository userRepos;

	@Override
	public Iterable<StoreInfo> findAllInfo() {
		return storeRepos.findAllInfo();
	}
	
	@Override
	public Iterable<StoreInfo> findAllInfoActive() {
		return storeRepos.findAllInfoActive();
	}

	@Override
	public StoreInfo findInfoById(int id) {
		return storeRepos.findInfoById(id);
	}

	@Override
	public Stores findById(int id) {
		// TODO Auto-generated method stub
		return storeRepos.findById(id).get();
	}
	
	@Override
	public StoreInfo add(StoreInfo info) {
		
		return storeRepos.findInfoById(info.getId());
	}

	@Override 
	public StoreInfo update(int id, StoreInfo _object) 
	{ 
		Stores object = storeRepos.findById(id).get();
		object.setName(_object.getName());
		object.setEmail(_object.getEmail());
		object.setPhone(_object.getPhone());
		Users user = userRepos.findById(_object.getUserId()).get();
		object.setUsers(user);
		object.setLogo(_object.getLogo());
		object.setUpdated(new Date());
		
		storeRepos.save(object);
		
		return storeRepos.findInfoById(id); 
	}

	@Override
	public void delete(int id) {
		storeRepos.delete(storeRepos.findById(id).get());
	}

	@Override
	public int toggleStatus(int id) {
		return storeRepos.toggleStatus(id, new Date());
	}
	
	@Override
	public int updateBanTerm(int id, Date banTerm) {
		return storeRepos.updateBanTerm(id, banTerm);
	}
}
