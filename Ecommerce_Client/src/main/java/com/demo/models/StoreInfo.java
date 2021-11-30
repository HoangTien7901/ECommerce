package com.demo.models;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StoreInfo {

	private int id;
	private Integer userId;
	private String userName;
	
	@NotNull
	@Length(min = 5, max = 100)
	private String name;
	
	@NotNull
	@Pattern(regexp = "^[0-9]*$", message = "This field can only contain number.")
	@Length(min = 9, max = 13)
	private String phone;
	
	@NotNull
	@Email
	private String email;
	
	private String logo;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date banTerm;

	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Date getBanTerm() {
		return banTerm;
	}

	public void setBanTerm(Date banTerm) {
		this.banTerm = banTerm;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public StoreInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StoreInfo(int id, Integer userId, String userName, String name, String phone, String email, String logo,
			Date created, Date banTerm, boolean status) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.logo = logo;
		this.created = created;
		this.banTerm = banTerm;
		this.status = status;
	}

}
