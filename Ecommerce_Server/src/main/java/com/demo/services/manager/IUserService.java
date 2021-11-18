package com.demo.services.manager;

import com.demo.entities.Users;
import com.demo.models.UserInfo;

public interface IUserService {

	public Iterable<UserInfo> findAllInfo();
	
	public UserInfo findInfoById(int id);
	
	public Users findById(int id);

}
