package com.demo.entities;

public class Branchs {
	private Integer id;
	private String name;
	private String logo;
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Branchs(Integer id, String name, String logo) {
		super();
		this.id = id;
		this.name = name;
		this.logo = logo;
	}
	public Branchs() {
		super();
	}
	
	
}
