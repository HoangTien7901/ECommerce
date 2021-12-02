package com.demo.models;

import java.util.Date;


public class CartsInfor {
	private Integer id;
	private int productid;	
	private int users;
	private int quantity;
	private double price;
	private Date created;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
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
	public CartsInfor(Integer id, int productid, int users, int quantity, double price, Date created) {
		super();
		this.id = id;
		this.productid = productid;
		this.users = users;
		this.quantity = quantity;
		this.price = price;
		this.created = created;
	}
	public CartsInfor() {
		super();
	}
	

	

}
