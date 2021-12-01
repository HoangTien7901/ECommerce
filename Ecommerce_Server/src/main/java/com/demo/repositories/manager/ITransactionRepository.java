package com.demo.repositories.manager;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.Transactions;
import com.demo.models.TransactionInfo;

public interface ITransactionRepository extends CrudRepository<Transactions, Integer> {

	@Query("select new com.demo.models.TransactionInfo(id, products.id, services.id, stores.name, price, quantity, tax, status, cancelReason) from Transactions")
	public Iterable<TransactionInfo> findAllInfo();
	
	@Query("select new com.demo.models.TransactionInfo(id, services.id, services.name, stores.name, price, quantity, tax, status, cancelReason, transactionDetails.created) from Transactions")
	public Iterable<TransactionInfo> findAllServiceInfo();
	
	@Query("select new com.demo.models.TransactionInfo(id, products.id, products.name, products.categories.name, products.branchs.name, transactionDetails.users.username, price, quantity, tax, note, status, cancelReason, transactionDetails.created) from Transactions where services.id is null")
	public Iterable<TransactionInfo> findAllProductInfo();
	
	@Query("select new com.demo.models.TransactionInfo(id, products.id, products.name, products.categories.name, products.branchs.name, transactionDetails.users.username, price, quantity, tax, note, status, cancelReason, transactionDetails.created) from Transactions where id = :id")
	public TransactionInfo findInfoById(@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query("update Transactions f set f.status = :status WHERE f.id = :id")
	public int updateStatus(@Param("id") int id, @Param("status") String status);
	
	@Modifying
	@Transactional
	@Query("update Transactions f set f.status = :status, f.cancelReason = :reason WHERE f.id = :id")
	public int updateStatus(@Param("id") int id, @Param("status") String status, @Param("reason") String reason);
	
}
