package com.demo.models;

public class CategoryInfo {

	private int id;
	private String name;

	private Integer parentId;
	private String parentName;

	private boolean status;
	
	private int level;

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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CategoryInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CategoryInfo(int id, String name, Integer parentId, boolean status, int level) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.status = status;
		this.level = level;
	}

}
