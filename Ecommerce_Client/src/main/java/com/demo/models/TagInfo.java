package com.demo.models;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class TagInfo {
	
	private int id;
	
	@NotNull
	@Length(min = 4, max = 100)
	private String name;
	
	private boolean status;

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public TagInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TagInfo(int id, String name, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
}
