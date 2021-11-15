package com.demo.entities;
// Generated Nov 15, 2021, 3:44:29 PM by Hibernate Tools 5.4.30.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Services generated by hbm2java
 */
public class Services implements java.io.Serializable {

	private Integer id;
	private Users usersByCreatedId;
	private Users usersByUpdatedId;
	private String name;
	private String description;
	private double originalPrice;
	private double price;
	private int duration;
	private Date created;
	private Date updated;
	private Set transactionses = new HashSet(0);

	public Services() {
	}

	public Services(Users usersByCreatedId, Users usersByUpdatedId, String name, String description,
			double originalPrice, double price, int duration, Date created, Date updated) {
		this.usersByCreatedId = usersByCreatedId;
		this.usersByUpdatedId = usersByUpdatedId;
		this.name = name;
		this.description = description;
		this.originalPrice = originalPrice;
		this.price = price;
		this.duration = duration;
		this.created = created;
		this.updated = updated;
	}

	public Services(Users usersByCreatedId, Users usersByUpdatedId, String name, String description,
			double originalPrice, double price, int duration, Date created, Date updated, Set transactionses) {
		this.usersByCreatedId = usersByCreatedId;
		this.usersByUpdatedId = usersByUpdatedId;
		this.name = name;
		this.description = description;
		this.originalPrice = originalPrice;
		this.price = price;
		this.duration = duration;
		this.created = created;
		this.updated = updated;
		this.transactionses = transactionses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUsersByCreatedId() {
		return this.usersByCreatedId;
	}

	public void setUsersByCreatedId(Users usersByCreatedId) {
		this.usersByCreatedId = usersByCreatedId;
	}

	public Users getUsersByUpdatedId() {
		return this.usersByUpdatedId;
	}

	public void setUsersByUpdatedId(Users usersByUpdatedId) {
		this.usersByUpdatedId = usersByUpdatedId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getOriginalPrice() {
		return this.originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Set getTransactionses() {
		return this.transactionses;
	}

	public void setTransactionses(Set transactionses) {
		this.transactionses = transactionses;
	}

}