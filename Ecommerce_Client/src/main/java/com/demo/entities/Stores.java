package com.demo.entities;

import java.util.Date;

public class Stores {

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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getExpiry() {
		return expiry;
	}
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Stores(Integer id, Users users, String name, String phone, String email, String address, String logo,
			Date created, Date expiry, Date updated, boolean status) {
		super();
		this.id = id;
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
	public Stores() {
		super();
	}
	
	
}
