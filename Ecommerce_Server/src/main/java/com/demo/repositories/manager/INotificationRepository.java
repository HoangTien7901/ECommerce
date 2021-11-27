package com.demo.repositories.manager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Notifications;
import com.demo.entities.Tags;
import com.demo.models.CategoryInfo;
import com.demo.models.NotificationInfo;
import com.demo.models.TagInfo;

public interface INotificationRepository extends CrudRepository<Notifications, Integer> {

	@Query("select new com.demo.models.NotificationInfo(id, stores.id, users.id, content, created, isRead, isAllUser, isAllStore) from Notifications")
	public Iterable<NotificationInfo> findAllInfo();
	
	@Query("select new com.demo.models.NotificationInfo(id, stores.id, users.id, content, created, isRead, isAllUser, isAllStore) from Notifications where id = :id")
	public NotificationInfo findInfoById(@Param("id") int id);
	
	@Query("select new com.demo.models.NotificationInfo(id, stores.id, users.id, users.username, content, created, isRead) from Notifications where id = :id")
	public NotificationInfo findInfoUserById(@Param("id") int id);
	
	@Query("select new com.demo.models.NotificationInfo(id, stores.id, stores.name, content, created, isRead) from Notifications where id = :id")
	public NotificationInfo findInfoStoreById(@Param("id") int id);
	
}
