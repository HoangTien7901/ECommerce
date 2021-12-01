package com.demo.entities;

public class Contacts {

	private String name;
	private String email;
	private String phone;
	private String address;
	private boolean status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Contacts( String name, String email, String phone, String address, boolean status) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.status = status;
	}

	public Contacts() {
	}

}
