package com.demo.repositories.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.entities.Users;
import com.demo.models.UserInfo;

@Repository("userRepositories")
public interface UserRepositories extends CrudRepository<Users, Integer> {

	@Query("select new com.demo.models.UserInfo(id, username, password, roles.id, fullname, birthday, phone, email, status, address) from Users where username = :username")
	public UserInfo getInfoByUsername(@Param("username") String username);
	
	@Query("select new com.demo.models.UserInfo(id, username, password, roles.id, fullname, birthday, phone, email, status, address) from Users where id = :id")
	public UserInfo getInfoById(@Param("id") int id);
	
	public Users findByUsername(String username);
	
}
