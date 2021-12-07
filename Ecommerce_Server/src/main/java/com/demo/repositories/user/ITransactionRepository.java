package com.demo.repositories.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Transactions;
import com.demo.models.TransactionInfo;

@Repository("userTransactionRepos")
public interface ITransactionRepository extends CrudRepository<Transactions, Integer> {
	
	@Query("select new com.demo.models.TransactionInfo(id, products.id, products.name, products.categories.name, products.branchs.name, transactionDetails.users.username, price, quantity, tax, note, status, cancelReason, transactionDetails.created) from Transactions where transactionDetails.users.id = :userId")
	public Iterable<TransactionInfo> findAllInfoByUserId(@Param("userId") int userId);
	
}
