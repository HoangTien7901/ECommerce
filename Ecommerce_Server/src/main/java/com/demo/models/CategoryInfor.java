package com.demo.models;



public class CategoryInfor {

	private Integer id;
	private int categoryID;
	private String name;
	private double discountPercent;
	private boolean status;
	private int level;
	
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
	public double getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public CategoryInfor(Integer id, int categoryID, String name, double discountPercent, boolean status, int level) {
		super();
		this.id = id;
		this.categoryID = categoryID;
		this.name = name;
		this.discountPercent = discountPercent;
		this.status = status;
		this.level = level;
	}
	public CategoryInfor() {
		super();
	}
	
	
}
