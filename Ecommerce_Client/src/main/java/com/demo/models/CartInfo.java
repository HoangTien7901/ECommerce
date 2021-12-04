package com.demo.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Admin
 *
 */
public class CartInfo {

	private int id;
	private Iterable<Integer> productIds;
	private Integer userId;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;
	
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Iterable<Integer> getProductIds() {
		return productIds;
	}

	public void setProductIds(Iterable<Integer> productIds) {
		this.productIds = productIds;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CartInfo(int id, Iterable<Integer> productIds, Integer userId, Date created) {
		super();
		this.id = id;
		this.productIds = productIds;
		this.userId = userId;
		this.created = created;
	}
	
	public CartInfo(int id, Integer userId, Date created, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.created = created;
		this.status = status;
	}

	public CartInfo() {
		super();
	}
}
