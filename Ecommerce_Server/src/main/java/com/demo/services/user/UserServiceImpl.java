package com.demo.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.UserId;
import com.demo.repositories.user.UserRepositories;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositories userRepositories;
	
	@Override
	public UserId getIdUser() {
		return userRepositories.getIdUser();
		
	}

}
