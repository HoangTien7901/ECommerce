package com.demo.services.user;

import com.demo.models.BranchInfo;

public interface BranchService {
	
	public Iterable<BranchInfo> findAll();
	
	public BranchInfo find(int id);
}
