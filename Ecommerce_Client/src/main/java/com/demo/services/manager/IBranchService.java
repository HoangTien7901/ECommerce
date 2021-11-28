package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.models.BranchInfo;

public interface IBranchService {

	public ResponseEntity<Iterable<BranchInfo>> findAllInfo();
	
	public ResponseEntity<BranchInfo> findInfoById(int id);

	public ResponseEntity<BranchInfo> create(BranchInfo object);
	
	public ResponseEntity<Void> update(BranchInfo object);
	
	public ResponseEntity<Void> delete(int id);
}
