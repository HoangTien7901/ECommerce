package com.demo.services.manager;


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
	public UserInfo findInfoById(int id) {
		return repos.findInfoById(id);
	}

	@Override
	public Users findById(int id) {
		return repos.findById(id).get();
	}
}
