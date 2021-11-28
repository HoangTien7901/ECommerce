package com.demo.services.manager;


import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Users;
import com.demo.models.UserInfo;
import com.demo.repositories.manager.IUserRepository;

@Service("user")
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repos;

	@Override
	public Iterable<UserInfo> findAllInfo() {
		return repos.findAllInfo();
	}

	@Override
	public Iterable<UserInfo> findAllInfoActive() {
		return repos.findAllInfoActive();
	}

	@Override
	public UserInfo findInfoById(int id) {
		return repos.findInfoById(id);
	}

	@Override
	public Users findById(int id) {
		return repos.findById(id).get();
	}
	
	@Override
	public UserInfo update(int id, UserInfo _object) {
		Users object = repos.findById(id).get();
		
		object.setUsername(_object.getUsername());
		object.setFullname(_object.getFullname());
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(_object.getBirthday());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		
		object.setBirthday(calendar.getTime());
		object.setPhone(_object.getPhone());
		object.setEmail(_object.getEmail());
		object.setUpdated(new Date());
		
		object = repos.save(object);
		
		return repos.findInfoById(id);
	}

	@Override
	public void delete(int id) {
		repos.delete(repos.findById(id).get());
	}

	@Override
	public int toggleStatus(int id) {
		return repos.toggleStatus(id, new Date());
	}
	
	@Override
	public int updateBanTerm(int id, Date banTerm) {
		return repos.updateBanTerm(id, banTerm);
	}
}
