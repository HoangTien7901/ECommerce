package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.models.ServiceInfo;

public interface IServiceService {

	public ResponseEntity<Iterable<ServiceInfo>> findAllInfo();
	
	public ResponseEntity<ServiceInfo> findInfoById(int id);

	public ResponseEntity<ServiceInfo> create(ServiceInfo object);
	
	public ResponseEntity<Void> update(ServiceInfo object);
	
	public ResponseEntity<Void> delete(int id);
}
