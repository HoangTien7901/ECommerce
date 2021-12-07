package com.demo.services.user;

import com.demo.models.UserInfo;

public interface UserService {

	public UserInfo findInfoByUsername(String username);
	
	public UserInfo create(UserInfo _object);
	
	public UserInfo update(int id, UserInfo _object);
	
}
