package com.demo.models;

public class ImageInfo {
	private int id;
	private Integer bannerId;
	private Integer productId;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getBannerId() {
		return bannerId;
	}

	public void setBannerId(Integer bannerId) {
		this.bannerId = bannerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageInfo(int id, Integer bannerId, Integer productId, String name) {
		super();
		this.id = id;
		this.bannerId = bannerId;
		this.productId = productId;
		this.name = name;
	}

	public ImageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
