package com.demo.services.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Users;
import com.demo.models.UserInfo;
import com.demo.repositories.user.RoleRepository;
import com.demo.repositories.user.UserRepositories;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositories userRepos;
	
	@Autowired
	private RoleRepository roleRepos;
	
	@Override
	public UserInfo findInfoByUsername(String username) {
		return userRepos.getInfoByUsername(username);
	}

	@Override
	public UserInfo create(UserInfo _object) {
		Users user = new Users();
		user.setUsername(_object.getUsername());
		user.setPassword(_object.getPassword());
		
		user.setRoles(roleRepos.findById(1).get());
		
		user.setFullname(_object.getFullname());
		user.setBirthday(_object.getBirthday());
		user.setPhone(_object.getPhone());
		user.setEmail(_object.getEmail());
		user.setCreated(new Date());
		user.setStatus(true);
		
		user = userRepos.save(user);
		
		return userRepos.getInfoByUsername(user.getUsername());
	}
	
}
