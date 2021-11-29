package com.demo.repositories.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Branchs;
import com.demo.models.BranchInfo;

@Repository("branchRepository")
public interface BranchRepository extends CrudRepository<Branchs, Integer> {

	@Query(value = "select new com.demo.models.BranchInfo("
			+ "id, name, logo) "
			+ "from com.demo.entities.Branchs")
	public Iterable<BranchInfo> getList();
	
	@Query(value = "select new com.demo.models.BranchInfo("
			+ "id, name, logo) "
			+ "from com.demo.entities.Branchs where id = :id")
	public BranchInfo find(@Param("id") int id);
}
