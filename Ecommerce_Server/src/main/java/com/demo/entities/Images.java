package com.demo.entities;
// Generated Nov 21, 2021, 9:53:03 AM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Images generated by hbm2java
 */
@Entity
@Table(name = "images")
public class Images implements java.io.Serializable {

	private Integer id;
	private Banners banners;
	private Products products;
	private String name;

	public Images() {
	}

	public Images(String name) {
		this.name = name;
	}

	public Images(Banners banners, Products products, String name) {
		this.banners = banners;
		this.products = products;
		this.name = name;
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
	@JoinColumn(name = "banner_id")
	public Banners getBanners() {
		return this.banners;
	}

	public void setBanners(Banners banners) {
		this.banners = banners;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
