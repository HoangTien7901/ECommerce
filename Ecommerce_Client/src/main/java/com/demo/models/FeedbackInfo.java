package com.demo.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FeedbackInfo {

	private int id;
	private Integer userId;
	private String username;
	private String content;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;
	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public FeedbackInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public FeedbackInfo(int id, Integer userId, String username, String content, Date created, boolean status) {
		super();
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.content = content;
		this.created = created;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
