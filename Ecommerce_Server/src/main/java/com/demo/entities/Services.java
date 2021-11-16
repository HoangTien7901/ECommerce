package com.demo.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Services generated by hbm2java
 */
@Entity
@Table(name = "services", catalog = "ecommerce_db")
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
	private Set<Transactions> transactionses = new HashSet<Transactions>(0);

	public Services() {
	}

	public Services(Users usersByCreatedId, String name, String description, double originalPrice, double price,
			int duration, Date created) {
		this.usersByCreatedId = usersByCreatedId;
		this.name = name;
		this.description = description;
		this.originalPrice = originalPrice;
		this.price = price;
		this.duration = duration;
		this.created = created;
	}

	public Services(Users usersByCreatedId, Users usersByUpdatedId, String name, String description,
			double originalPrice, double price, int duration, Date created, Date updated,
			Set<Transactions> transactionses) {
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

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_id", nullable = false)
	public Users getUsersByCreatedId() {
		return this.usersByCreatedId;
	}

	public void setUsersByCreatedId(Users usersByCreatedId) {
		this.usersByCreatedId = usersByCreatedId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_id")
	public Users getUsersByUpdatedId() {
		return this.usersByUpdatedId;
	}

	public void setUsersByUpdatedId(Users usersByUpdatedId) {
		this.usersByUpdatedId = usersByUpdatedId;
	}

	@Column(name = "name", nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false, length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "original_price", nullable = false, precision = 22, scale = 0)
	public double getOriginalPrice() {
		return this.originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "duration", nullable = false)
	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created", nullable = false, length = 10)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updated", length = 10)
	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "services")
	public Set<Transactions> getTransactionses() {
		return this.transactionses;
	}

	public void setTransactionses(Set<Transactions> transactionses) {
		this.transactionses = transactionses;
	}

}
