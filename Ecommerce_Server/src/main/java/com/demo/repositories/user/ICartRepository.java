package com.demo.repositories.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Carts;
import com.demo.models.CartInfo;

public interface ICartRepository extends CrudRepository<Carts, Integer> {
	
	@Query("select new com.demo.models.CartInfo(id, users.id, created, status) from Carts where id = :id")
	public CartInfo findInfoById(@Param("id") int id);
	
}
