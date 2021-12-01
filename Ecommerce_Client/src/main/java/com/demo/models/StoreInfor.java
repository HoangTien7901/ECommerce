package com.demo.models;

import java.util.Date;

public class StoreInfor {

	private int id;
	private String name;
	private String phone;
	private String address;
	private String logo;
	private Date created;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public StoreInfor(int id, String name, String phone, String address, String logo, Date created) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.logo = logo;
		this.created = created;
	}
	public StoreInfor() {
		super();
	}
	
	
	
}
