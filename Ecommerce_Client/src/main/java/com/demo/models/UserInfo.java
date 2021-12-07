package com.demo.models;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserInfo {
	
	private int id;
	
	@NotNull
	@Pattern(regexp = "^(?=.{6,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$", 
	message = "Username must have from 6 to 20 characters, only contains alphanumeric characters and underscore "
			+ "and dot in between with no underscore and/or dot next to each other.")
	private String username;
	
	@NotNull
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", 
	message = "Password must have from 8 to 20 characters including at least one uppercase letter, one number and one special character.")
	private String password;
	
	private Integer roleId;
	
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	
	@NotNull
	@Length(min = 5, max = 100)
	private String fullname;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	
	@NotNull
	@Pattern(regexp = "^[0-9]*$", message = "This field can only contain number.")
	@Length(min = 9, max = 13)
	private String phone;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date updated;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date banTerm;
	
	private boolean status;
	
	@NotNull
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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
	
	public Date getBanTerm() {
		return banTerm;
	}

	public void setBanTerm(Date banTerm) {
		this.banTerm = banTerm;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserInfo(int id, String username, String password, Integer roleId, String fullname, Date birthday, String phone, String email, boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.fullname = fullname;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.status = status;
	}

	public UserInfo(int id, String username, String password, Integer roleId, String fullname, Date birthday,
			String phone, String email, Date created, Date updated, Date banTerm, boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.fullname = fullname;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.created = created;
		this.updated = updated;
		this.banTerm = banTerm;
		this.status = status;
	}
	
	public UserInfo(int id, String username, String password, Integer roleId, String fullname, Date birthday, String phone, String email, boolean status
			,String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.fullname = fullname;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.address = address;
	}
}
