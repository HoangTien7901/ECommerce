package com.demo.repositories.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.TransactionDetails;
import com.demo.models.TransactionDetailsInfo;

public interface ITransactionDetailsRepository extends CrudRepository<TransactionDetails, Integer> {
	
	@Query("select new com.demo.models.TransactionDetailsInfo(id, users.id, name, payment, address, quantity, created) from TransactionDetails where id = :id")
	public TransactionDetailsInfo findInfoById(@Param("id") int id);
	
}
