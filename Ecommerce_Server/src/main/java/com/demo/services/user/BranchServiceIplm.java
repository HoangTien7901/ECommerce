package com.demo.services.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.BranchInfo;
import com.demo.repositories.user.BranchRepository;

@Service("branchService")
public class BranchServiceIplm implements BranchService {

	@Autowired
	private BranchRepository branchRepository;

	@Override
	public Iterable<BranchInfo> findAll() {
		return branchRepository.getList();
	}

	@Override
	public BranchInfo find(int id) {
		return branchRepository.find(id);
	}

	

}
