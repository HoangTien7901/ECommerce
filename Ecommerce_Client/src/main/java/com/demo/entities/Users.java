package com.demo.entities;

import java.util.Date;

public class Users {
	
	private Integer id;
	private Roles roles;
	private String username;
	private String password;
	private String fullname;
	private Date birthday;
	private String phone;
	private String email;
	private Date created;
	private Date updated;
	private boolean status;
	private Date banTerm;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
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
	public Date getBanTerm() {
		return banTerm;
	}
	public void setBanTerm(Date banTerm) {
		this.banTerm = banTerm;
	}
	public Users(Integer id, Roles roles, String username, String password, String fullname, Date birthday,
			String phone, String email, Date created, Date updated, boolean status, Date banTerm) {
		super();
		this.id = id;
		this.roles = roles;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.created = created;
		this.updated = updated;
		this.status = status;
		this.banTerm = banTerm;
	}
	public Users() {
		super();
	}
	
	
}
