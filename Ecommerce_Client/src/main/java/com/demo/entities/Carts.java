package com.demo.entities;

import java.util.Date;

public class Carts {
	
	private Integer id;
	private int productsId;
	private int usersId;
	private int quantity;
	private double price;
	private Date created;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getProductsId() {
		return productsId;
	}
	public void setProductsId(int productsId) {
		this.productsId = productsId;
	}
	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
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
	public Carts(Integer id, int productsId, int usersId, int quantity, double price, Date created) {
		super();
		this.id = id;
		this.productsId = productsId;
		this.usersId = usersId;
		this.quantity = quantity;
		this.price = price;
		this.created = created;
	}
	public Carts() {
		super();
	}

	
	
}
