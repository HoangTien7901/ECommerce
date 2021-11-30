package com.demo.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BannerInfo {

	private int id;
	private String caption;
	private String description;
	private String link;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date updated;
	
	private boolean status;
	
	private Integer creatorId;	
	private Integer updatorId;
	
	private Iterable<ImageInfo> imgs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Integer getUpdatorId() {
		return updatorId;
	}

	public void setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
	}
	
	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	
	public Iterable<ImageInfo> getImgs() {
		return imgs;
	}

	public void setImgs(Iterable<ImageInfo> imgs) {
		this.imgs = imgs;
	}

	public BannerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BannerInfo(int id, String caption, String description, String link, Date created, Date updated,
			boolean status, Integer creatorId, Integer updatorId) {
		super();
		this.id = id;
		this.caption = caption;
		this.description = description;
		this.link = link;
		this.created = created;
		this.updated = updated;
		this.status = status;
		this.creatorId = creatorId;
		this.updatorId = updatorId;
	}
}
