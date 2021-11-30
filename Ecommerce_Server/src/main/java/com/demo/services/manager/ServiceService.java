package com.demo.services.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Services;
import com.demo.entities.Tags;
import com.demo.entities.Users;
import com.demo.models.ServiceInfo;
import com.demo.repositories.manager.IServiceRepository;
import com.demo.repositories.manager.ITagRepository;
import com.demo.repositories.manager.IUserRepository;

@Service("service")
public class ServiceService implements IServiceService {

	@Autowired
	private IServiceRepository repos;
	
	@Autowired
	private IUserRepository userRepos;

	@Override
	public Iterable<ServiceInfo> findAllInfo() {
		Iterable<ServiceInfo> result = repos.findAllInfo();
		
		for (ServiceInfo service : result) {
			if (service.getCreatorId() != null) {
				service.setCreatorName(userRepos.findNameById(service.getCreatorId()));
			}
			
			if (service.getUpdaterId() != null) {
				service.setUpdaterName(userRepos.findNameById(service.getUpdaterId()));
			}
		}
				
		return result;
	}

	@Override
	public ServiceInfo findInfoById(int id) {
		return repos.findInfoById(id);
	}

	@Override
	public Services findById(int id) {
		return repos.findById(id).get();
	}

	@Override
	public ServiceInfo update(int id, ServiceInfo _object) {

		Services object = repos.findById(id).get();
		
		object.setName(_object.getName());
		object.setDescription(_object.getDescription());
		object.setOriginalPrice(_object.getOriginalPrice());
		object.setPrice(_object.getPrice());
		object.setDuration(_object.getDuration());

		object.setUpdated(new Date());
		
		Users user = userRepos.findById(_object.getUpdaterId()).get();
		object.setUsersByUpdatedId(user);
		
		object = repos.save(object);

		return repos.findInfoById(id);
	}

	@Override
	public void delete(int id) {
		repos.delete(repos.findById(id).get());
	}

	@Override
	public ServiceInfo add(ServiceInfo _object) {

		Services object = new Services();
		
		object.setName(_object.getName());
		object.setDescription(_object.getDescription());
		object.setOriginalPrice(_object.getOriginalPrice());
		object.setPrice(_object.getPrice());
		object.setDuration(_object.getDuration());

		object.setCreated(new Date());
		
		Users user = userRepos.findById(_object.getCreatorId()).get();
		object.setUsersByCreatedId(user);
		
		object = repos.save(object);
		
		return repos.findInfoById(object.getId());
	}
}
