package com.demo.repositories.manager;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.Users;
import com.demo.models.UserInfo;

public interface IUserRepository extends CrudRepository<Users, Integer> {

	@Query("select new com.demo.models.UserInfo(id, username, password, roles.id, fullname, birthday, phone, email, created, updated, banTerm, status) from Users where roles.id = 1")
	public Iterable<UserInfo> findAllInfo();
	
	@Query("select new com.demo.models.UserInfo(id, username, password, roles.id, fullname, birthday, phone, email, created, updated, banTerm, status) from Users")
	public Iterable<UserInfo> trueFindAllInfo();
	
	@Query("select new com.demo.models.UserInfo(id, username, password, roles.id, fullname, birthday, phone, email, created, updated, banTerm, status) from Users where status = 1")
	public Iterable<UserInfo> findAllInfoActive();
	
	@Query("select username from Users where id = :id")
	public String findNameById(@Param("id") int id);
	
	@Query("select new com.demo.models.UserInfo(id, username, password, roles.id, fullname, birthday, phone, email, created, updated, banTerm, status) from Users where id = :id")
	public UserInfo findInfoById(@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query("update Users f set f.updated = :updated, f.status = CASE f.status WHEN true THEN false ELSE true END WHERE f.id = :id")
	public int toggleStatus(@Param("id") int id, @Param("updated") Date updated);
	
	@Modifying
	@Transactional
	@Query("update Users f set f.banTerm = :banTerm WHERE f.id = :id")
	public int updateBanTerm(@Param("id") int id, @Param("banTerm") Date banTerm);
}
