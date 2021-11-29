package com.demo.repositories.user;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Transactions;
import com.demo.models.TransactionInfo;

@Repository("transactionRepository")
public interface TransactionRepository extends CrudRepository<Transactions, Integer> {

	@Query(value = "select new com.demo.models.TransactionInfo("
			+ "id, services.id, "
			+ "services.name, stores.id, stores.name, transactionDetails.id, "
			+ "transactionDetails.name, price, quantity, tax, total, "
			+ "status) from com.demo.entities.Transactions")
	public Iterable<TransactionInfo> getListService();
	
	@Query(value = "select new com.demo.models.TransactionInfo("
			+ "id, products.id, products.name, "
			+ " stores.id, stores.name, transactionDetails.id, "
			+ "transactionDetails.name, price, quantity, tax, total, note, "
			+ "status) from com.demo.entities.Transactions")
	public Iterable<TransactionInfo> getListOrder();
	
	@Query(value = "select new com.demo.models.TransactionInfo("
			+ "id, products.id, products.name, "
			+ " stores.id, stores.name, transactionDetails.id, "
			+ "transactionDetails.name, price, quantity, tax, total, note, "
			+ "status) from com.demo.entities.Transactions WHERE id = :id")
	public TransactionInfo find(@Param("id") int id);
}
