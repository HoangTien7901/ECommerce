package com.demo.models;

import java.util.List;

public class CategoryInfo {

	private int id;
	private String name;
	private double discount_percent;
	
	private Integer parentId;
	private String parentName;
	
	private List<CategoryInfo> childCategories;

	private boolean status;
	
	private int level;

	public List<CategoryInfo> getChildCategories() {
		return childCategories;
	}

	public void setChildCategories(List<CategoryInfo> childCategories) {
		this.childCategories = childCategories;
	}

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
	
	public double getDiscount_percent() {
		return discount_percent;
	}

	public void setDiscount_percent(double discount_percent) {
		this.discount_percent = discount_percent;
	}

	public CategoryInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public CategoryInfo(int id, String name, double discount_percent, Integer parentId, boolean status, int level) {
		super();
		this.id = id;
		this.name = name;
		this.discount_percent = discount_percent;
		this.parentId = parentId;
		this.status = status;
		this.level = level;
	}

	public CategoryInfo(int id, String name, Integer parentId, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.status = status;
	}
	
	public CategoryInfo(int id, String name, Integer parentId, boolean status, int level) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.status = status;
		this.level = level;
	}

	public CategoryInfo(int id, String name, Integer parentId, List<CategoryInfo> childCategories, boolean status,
			int level) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.childCategories = childCategories;
		this.status = status;
		this.level = level;
	}
	
}
