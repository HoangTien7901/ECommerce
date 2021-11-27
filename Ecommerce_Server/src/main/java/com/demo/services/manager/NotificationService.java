package com.demo.services.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Notifications;
import com.demo.entities.Stores;
import com.demo.entities.Users;
import com.demo.models.NotificationInfo;
import com.demo.repositories.manager.INotificationRepository;
import com.demo.repositories.manager.IStoreRepository;
import com.demo.repositories.manager.IUserRepository;

@Service("notification")
public class NotificationService implements INotificationService {

	@Autowired
	private INotificationRepository notifiRepos;

	@Autowired
	private IUserRepository userRepos;

	@Autowired
	private IStoreRepository storeRepos;

	@Override
	public Iterable<NotificationInfo> findAllInfo() {
		Iterable<NotificationInfo> result = notifiRepos.findAllInfo();
		for (NotificationInfo item : result) {
			if (item.getStoreId() != null) {
				item.setStoreName(storeRepos.findNameById(item.getStoreId()));
			} else if (item.getUserId() != null) {
				item.setUserName(userRepos.findNameById(item.getUserId()));
			}
		}

		return result;
	}

	@Override
	public NotificationInfo findInfoById(int id) {
		return notifiRepos.findInfoById(id);
	}

	@Override
	public Notifications findById(int id) {
		return notifiRepos.findById(id).get();
	}

	@Override
	public NotificationInfo update(int id, NotificationInfo _object) {
		Notifications object = notifiRepos.findById(_object.getId()).get();
		
		object.setContent(_object.getContent());

		if (_object.getStoreId() != null) {
			Stores store = storeRepos.findById(_object.getStoreId()).get();
			object.setStores(store);
		} else if (_object.getUserId() != null) {
			Users user = userRepos.findById(_object.getUserId()).get();
			object.setUsers(user);
		}

		object.setIsAllStore(_object.isAllStore());
		object.setIsAllUser(_object.isAllUser());
		object.setIsRead(false);
		
		object = notifiRepos.save(object);
		
		return notifiRepos.findInfoById(object.getId());
	}

	@Override
	public void delete(int id) {
		notifiRepos.delete(notifiRepos.findById(id).get());
	}

	@Override
	public NotificationInfo add(NotificationInfo _object) {
		Notifications object = new Notifications();
		object.setContent(_object.getContent());
		object.setCreated(new Date());

		if (_object.getStoreId() != null) {
			Stores store = storeRepos.findById(_object.getStoreId()).get();
			object.setStores(store);
		} else if (_object.getUserId() != null) {
			Users user = userRepos.findById(_object.getUserId()).get();
			object.setUsers(user);
		}

		object.setIsAllStore(_object.isAllStore());
		object.setIsAllUser(_object.isAllUser());
		object.setIsRead(false);
		object = notifiRepos.save(object);
		
		return notifiRepos.findInfoById(object.getId());
	}
}
