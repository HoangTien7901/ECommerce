package com.demo.entities;
// Generated Nov 15, 2021, 3:44:29 PM by Hibernate Tools 5.4.30.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Stores generated by hbm2java
 */
public class Stores implements java.io.Serializable {

	private Integer id;
	private Users users;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String logo;
	private Date created;
	private Date expiry;
	private Date updated;
	private boolean status;
	private Set chatChanelses = new HashSet(0);
	private Set productses = new HashSet(0);
	private Set notificationses = new HashSet(0);
	private Set chatMessageses = new HashSet(0);
	private Set transactionses = new HashSet(0);

	public Stores() {
	}

	public Stores(Users users, String name, String phone, String email, String address, String logo, Date created,
			Date expiry, Date updated, boolean status) {
		this.users = users;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.logo = logo;
		this.created = created;
		this.expiry = expiry;
		this.updated = updated;
		this.status = status;
	}

	public Stores(Users users, String name, String phone, String email, String address, String logo, Date created,
			Date expiry, Date updated, boolean status, Set chatChanelses, Set productses, Set notificationses,
			Set chatMessageses, Set transactionses) {
		this.users = users;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.logo = logo;
		this.created = created;
		this.expiry = expiry;
		this.updated = updated;
		this.status = status;
		this.chatChanelses = chatChanelses;
		this.productses = productses;
		this.notificationses = notificationses;
		this.chatMessageses = chatMessageses;
		this.transactionses = transactionses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getExpiry() {
		return this.expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set getChatChanelses() {
		return this.chatChanelses;
	}

	public void setChatChanelses(Set chatChanelses) {
		this.chatChanelses = chatChanelses;
	}

	public Set getProductses() {
		return this.productses;
	}

	public void setProductses(Set productses) {
		this.productses = productses;
	}

	public Set getNotificationses() {
		return this.notificationses;
	}

	public void setNotificationses(Set notificationses) {
		this.notificationses = notificationses;
	}

	public Set getChatMessageses() {
		return this.chatMessageses;
	}

	public void setChatMessageses(Set chatMessageses) {
		this.chatMessageses = chatMessageses;
	}

	public Set getTransactionses() {
		return this.transactionses;
	}

	public void setTransactionses(Set transactionses) {
		this.transactionses = transactionses;
	}

}