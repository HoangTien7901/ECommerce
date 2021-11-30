package com.demo.models;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ServiceInfo {
	private int id;
	
	private Integer creatorId;
	private String creatorName;
	
	private Integer updaterId;
	private String updaterName;
	
	@NotNull
	@Length(min = 5, max = 100)
	private String name;
	
	@NotNull
	@Length(min = 10, max = 500)
	private String description;
	
	@NotNull
	@Min(0)
	private double originalPrice;
	
	@NotNull
	@Min(0)
	private double price;
	
	@NotNull
	@Min(1)
	private int duration;
	
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date created;
	
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date updated;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public Integer getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(Integer updaterId) {
		this.updaterId = updaterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getUpdaterName() {
		return updaterName;
	}

	public void setUpdaterName(String updaterName) {
		this.updaterName = updaterName;
	}

	public ServiceInfo(int id, Integer creatorId, Integer updaterId, String name, String description,
			double originalPrice, double price, int duration, Date created, Date updated) {
		super();
		this.id = id;
		this.creatorId = creatorId;
		this.updaterId = updaterId;
		this.name = name;
		this.description = description;
		this.originalPrice = originalPrice;
		this.price = price;
		this.duration = duration;
		this.created = created;
		this.updated = updated;
	}

	public ServiceInfo() {
		super();
	}
	
}
