package com.demo.models;
// Generated Nov 24, 2021, 4:10:46 PM by Hibernate Tools 5.1.10.Final


/**
 * Tags generated by hbm2java
 */
public class TagInfo{

	private Integer id;
	private String name;
	private boolean status;
	
	
	public TagInfo() {
		super();
	}
	public TagInfo(Integer id, String name, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	

}