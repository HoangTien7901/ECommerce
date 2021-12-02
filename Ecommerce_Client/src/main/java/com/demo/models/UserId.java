package com.demo.models;

public class UserId {

	private int id;
	private int roles;
	private String fullname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoles() {
		return roles;
	}
	public void setRoles(int roles) {
		this.roles = roles;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public UserId(int id, int roles, String fullname) {
		super();
		this.id = id;
		this.roles = roles;
		this.fullname = fullname;
	}
	
	public UserId() {
		super();
	}
	
}
