package com.demo.models;

public class BranchInfo {

	private int id;
	private String name;
	private String logo;

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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public BranchInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BranchInfo(int id, String name, String logo) {
		super();
		this.id = id;
		this.name = name;
		this.logo = logo;
	}

}
