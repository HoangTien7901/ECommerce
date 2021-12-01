package com.demo.models;


public class Item {

	private Products product;
	private int quantity;

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item() {
		super();
	}

	public Item(Products product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

}
