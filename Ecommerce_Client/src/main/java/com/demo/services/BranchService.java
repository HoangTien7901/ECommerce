package com.demo.services;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.models.BranchInfo;

public interface BranchService {
	
	public ResponseEntity<List<BranchInfo>> findAll();
	
}
