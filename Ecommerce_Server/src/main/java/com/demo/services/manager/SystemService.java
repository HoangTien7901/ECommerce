package com.demo.services.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.System;
import com.demo.repositories.manager.ISystemRepository;

@Service("system")
public class SystemService implements ISystemService {

	@Autowired
	private ISystemRepository repos;

	@Override
	public System getSystem() {
		return repos.findById(1).get();
	}

	@Override
	public System update(System _object) {
		return repos.save(_object);
	}
	
}
