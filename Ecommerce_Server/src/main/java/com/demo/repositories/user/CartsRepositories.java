package com.demo.repositories.user;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Carts;
import com.demo.models.CartsInfor;

@Repository("cartsRepositories")
public interface CartsRepositories extends CrudRepository<Carts, Integer> {

	@Query("delete from Carts where products.id = :id ")
	public Boolean deleteByIdProduct(@Param("id") int id );

	@Query("select new com.demo.models.CartsInfor(id, products.id , users.id , quantity, price, created) from Carts ")
	public List<CartsInfor> findAllCart();
	
	
}
