package com.demo.repositories.manager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Services;
import com.demo.entities.Tags;
import com.demo.models.CategoryInfo;
import com.demo.models.ServiceInfo;
import com.demo.models.TagInfo;

public interface IServiceRepository extends CrudRepository<Services, Integer> {

	@Query("select new com.demo.models.ServiceInfo(id, usersByCreatedId.id, usersByUpdatedId.id, name, description, originalPrice, price, duration, created, updated) from Services")
	public Iterable<ServiceInfo> findAllInfo();
	
	@Query("select new com.demo.models.ServiceInfo(id, usersByCreatedId.id, usersByUpdatedId.id, name, description, originalPrice, price, duration, created, updated) from Services where id = :id")
	public ServiceInfo findInfoById(@Param("id") int id);
	
}
