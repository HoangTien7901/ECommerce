package com.demo.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class Contacts {

	private Integer id;
	
	@NotNull
	@Length(min = 5, max = 200)
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Pattern(regexp = "^[0-9]*$", message = "This field can only contain number.")
	@Length(min = 9, max = 13)
	private String phone;
	
	@NotNull
	@Length(min = 5, max = 100)
	private String address;
	
	private boolean status;

	public Contacts() {
	}

	public Contacts(String name, String email, String phone, String address, boolean status) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.status = status;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
