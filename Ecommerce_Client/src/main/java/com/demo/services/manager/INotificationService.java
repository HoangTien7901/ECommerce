package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.models.NotificationInfo;

public interface INotificationService {
	
	public ResponseEntity<Iterable<NotificationInfo>> findAllInfo();

	public ResponseEntity<NotificationInfo> findInfoById(int id);
	
	public ResponseEntity<NotificationInfo> create(NotificationInfo img);
	
	public ResponseEntity<Void> update(NotificationInfo img);
	
	public ResponseEntity<Void> delete(int id);
}
