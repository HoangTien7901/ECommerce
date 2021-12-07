package com.demo.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransactionDetailsInfo {

	private int id;
	private int userId;
	private String name;
	private String payment;
	private String address;
	private int quantity;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public TransactionDetailsInfo(int id, int userId, String name, String payment, String address, int quantity,
			Date created) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.payment = payment;
		this.address = address;
		this.quantity = quantity;
		this.created = created;
	}

	public TransactionDetailsInfo() {
		super();
	}
	
}
