package com.demo.services.manager;

import com.demo.entities.Services;
import com.demo.models.ServiceInfo;

public interface IServiceService {

	public Iterable<ServiceInfo> findAllInfo();
	
	public ServiceInfo findInfoById(int id);
	
	public Services findById(int id);
	
	public ServiceInfo update(int id, ServiceInfo object);
	
	public void delete(int id);
	
	public ServiceInfo add(ServiceInfo object);

}
