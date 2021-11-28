package com.demo.models;

import java.util.Date;


public class CartsInfor  {

	private int id;
	private String productName;
	private String productImage;
	private int users;
	private int quantity;
	private double price;
	private Date created;
	
	public CartsInfor(Integer id, String productName, String productImage, int users, int quantity, double price,
			Date created) {
		super();
		this.id = id;
		this.productName = productName;
		this.productImage = productImage;
		this.users = users;
		this.quantity = quantity;
		this.price = price;
		this.created = created;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public CartsInfor() {
		super();
	}
	



	

}
