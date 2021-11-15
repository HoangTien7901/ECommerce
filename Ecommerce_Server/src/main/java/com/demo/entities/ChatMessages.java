package com.demo.entities;
// Generated Nov 15, 2021, 3:44:29 PM by Hibernate Tools 5.4.30.Final

import java.util.Date;

/**
 * ChatMessages generated by hbm2java
 */
public class ChatMessages implements java.io.Serializable {

	private Integer id;
	private Stores stores;
	private Users users;
	private boolean isUserSender;
	private Date timeSent;
	private String content;

	public ChatMessages() {
	}

	public ChatMessages(Stores stores, Users users, boolean isUserSender, Date timeSent, String content) {
		this.stores = stores;
		this.users = users;
		this.isUserSender = isUserSender;
		this.timeSent = timeSent;
		this.content = content;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Stores getStores() {
		return this.stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public boolean isIsUserSender() {
		return this.isUserSender;
	}

	public void setIsUserSender(boolean isUserSender) {
		this.isUserSender = isUserSender;
	}

	public Date getTimeSent() {
		return this.timeSent;
	}

	public void setTimeSent(Date timeSent) {
		this.timeSent = timeSent;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
