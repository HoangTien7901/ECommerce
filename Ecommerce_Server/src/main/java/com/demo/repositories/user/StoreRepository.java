package com.demo.repositories.user;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.entities.Stores;
import com.demo.models.StoreInfo;

@Repository("storeRepository")
public interface StoreRepository extends CrudRepository<Stores, Integer> {

	@Query(value = "select new com.demo.models.StoreInfo("
			+ "id, users.id, users.username, name, phone, email, address, logo, created, expiry, updated, status, banTerm)"
			+ "from com.demo.entities.Stores")
	public Iterable<StoreInfo> getList();
	
	@Query(value = "select new com.demo.models.StoreInfo("
			+ "id, users.id, users.username, name, phone, email, address, logo, created, expiry, updated, status, banTerm)"
			+ "from com.demo.entities.Stores where id = :id")
	public StoreInfo find(@Param("id") int id);
}
