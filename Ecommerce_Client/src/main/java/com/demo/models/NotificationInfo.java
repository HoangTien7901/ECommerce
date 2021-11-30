package com.demo.models;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NotificationInfo {

	private int id;
	private Integer storeId;
	private String storeName;
	private Integer userId;
	private String userName;
	
	@NotNull
	@Length(min = 10, max = 500)
	private String content;
	
	private boolean isAllUser;
	private boolean isAllStore;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;

	private boolean isRead;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public boolean isAllUser() {
		return isAllUser;
	}

	public void setAllUser(boolean isAllUser) {
		this.isAllUser = isAllUser;
	}

	public boolean isAllStore() {
		return isAllStore;
	}

	public void setAllStore(boolean isAllStore) {
		this.isAllStore = isAllStore;
	}

	public NotificationInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NotificationInfo(int id, Integer storeId, Integer userId, String content, Date created, boolean isRead,
			boolean isAllUser, boolean isAllStore) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.userId = userId;
		this.content = content;
		this.isAllUser = isAllUser;
		this.isAllStore = isAllStore;
		this.created = created;
		this.isRead = isRead;
	}

	// constructor for notification for users
	public NotificationInfo(int id, Integer storeId, Integer userId, String username, String content, Date created, boolean isRead) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.userId = userId;
		this.userName = username;
		this.content = content;
		this.created = created;
		this.isRead = isRead;
	}

	// constructor for all
	public NotificationInfo(int id, Integer storeId, String storeName, Integer userId, String userName, String content,
			Date created, boolean isRead) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.storeName = storeName;
		this.userId = userId;
		this.userName = userName;
		this.content = content;
		this.created = created;
		this.isRead = isRead;
	}
	
	public NotificationInfo(int id, Integer storeId, Integer userId, String content,
			Date created, boolean isRead) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.userId = userId;
		this.content = content;
		this.created = created;
		this.isRead = isRead;
	}
	
	// constructor for notification for stores
	public NotificationInfo(int id, Integer storeId, String storeName, String content,
			Date created, boolean isRead) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.storeName = storeName;
		this.content = content;
		this.created = created;
		this.isRead = isRead;
	}
}
