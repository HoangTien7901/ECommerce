package com.demo.services.manager;

import java.util.Date;

import com.demo.entities.Users;
import com.demo.models.UserInfo;

public interface IUserService {

	public Iterable<UserInfo> findAllInfo();
	
	public Iterable<UserInfo> findAllInfoActive();
	
	public UserInfo findInfoById(int id);
	
	public Users findById(int id);
	
	public UserInfo update(int id, UserInfo object);
	
	public void delete(int id);
	
	public int toggleStatus(int id);
	
	public int updateBanTerm(int id, Date banTerm);
}
