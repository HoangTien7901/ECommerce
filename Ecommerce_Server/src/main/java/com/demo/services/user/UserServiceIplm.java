package com.demo.services.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Users;
import com.demo.repositories.user.UserRepository;

@Service("userService")
public class UserServiceIplm implements UserService {

	@Autowired
	private UserRepository userRepository;	

	@Override
	public Users findById(int id) {
		return userRepository.findById(id).get();
	}

}
