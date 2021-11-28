package com.demo.repositories.manager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Branchs;
import com.demo.models.BranchInfo;

public interface IBranchRepository extends CrudRepository<Branchs, Integer> {
	
	@Query("select new com.demo.models.BranchInfo(id, name, logo) from Branchs")
	public Iterable<BranchInfo> findAllInfo();
	
	@Query("select new com.demo.models.BranchInfo(id, name, logo) from Branchs where id = :id")
	public BranchInfo findInfoById(@Param("id") int id);

	@Query("select name from Branchs where id = :id")
	public String findNameById(@Param("id") int id);
}