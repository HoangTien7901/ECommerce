package com.demo.models;

public class Images {
	
	private Integer id; 
	private int bannersid;
	private int productsid;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getBannersid() {
		return bannersid;
	}
	public void setBannersid(int bannersid) {
		this.bannersid = bannersid;
	}
	public int getProductsid() {
		return productsid;
	}
	public void setProductsid(int productsid) {
		this.productsid = productsid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Images(Integer id, int bannersid, int productsid, String name) {
		super();
		this.id = id;
		this.bannersid = bannersid;
		this.productsid = productsid;
		this.name = name;
	}
	public Images() {
		super();
	}
}
