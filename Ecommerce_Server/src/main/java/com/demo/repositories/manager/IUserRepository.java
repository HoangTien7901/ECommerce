package com.demo.repositories.manager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Users;
import com.demo.models.UserInfo;

public interface IUserRepository extends CrudRepository<Users, Integer> {

	@Query("select new com.demo.models.UserInfo(id, username, password, roles.id, fullname, birthday, phone, email, created, updated, status) from Users")
	public Iterable<UserInfo> findAllInfo();
	
	@Query("select new com.demo.models.UserInfo(id, username, password, roles.id, fullname, birthday, phone, email, created, updated, status) from Users where id = :id")
	public UserInfo findInfoById(@Param("id") int id);
}
