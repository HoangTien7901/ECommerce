package com.demo.services.manager;

import com.demo.entities.Notifications;
import com.demo.models.NotificationInfo;

public interface INotificationService {
	
	public Iterable<NotificationInfo> findAllInfo();
	
	public NotificationInfo findInfoById(int id);
	
	public Notifications findById(int id);
	
	public NotificationInfo update(int id, NotificationInfo object);
	
	public void delete(int id);
	
	public NotificationInfo add(NotificationInfo object);
}
