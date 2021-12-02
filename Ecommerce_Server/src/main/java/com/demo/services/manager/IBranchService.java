package com.demo.services.manager;

import com.demo.entities.Branchs;
import com.demo.models.BranchInfo;

public interface IBranchService {

	public Iterable<BranchInfo> findAllInfo();
	
	public BranchInfo findInfoById(int id);
	
	public Branchs findById(int id);
	
	public BranchInfo update(int id, BranchInfo object);
	
	public void delete(int id);
	
	public BranchInfo add(BranchInfo object);

}
