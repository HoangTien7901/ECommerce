package com.demo.models;
// Generated Nov 29, 2021, 10:03:26 AM by Hibernate Tools 5.1.10.Final

public class OrderInfo{

	private Integer id;
	private int storeId;
	private int quantity;
	private double originalPrice;
	private double price;
	private String status;
	
	
	public OrderInfo() {
		super();
	}
	public OrderInfo(Integer id, int storeId, int quantity, double originalPrice, double price, String status) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.quantity = quantity;
		this.originalPrice = originalPrice;
		this.price = price;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
