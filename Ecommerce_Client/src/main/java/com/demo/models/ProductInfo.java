package com.demo.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductInfo {
	private int id;
	private Integer branchId;
	private String branchName;
	private Integer categoryId;
	private String categoryName;
	private Integer storeId;
	private String storeName;
	private String name;
	private String avatar;
	private String description;
	private String descriptionDetail;

	private boolean isOutstanding;
	private boolean isBestSelling;
	private boolean isNewProduct;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date updated;

	private boolean status;
	private String banReason;
	private Boolean isLocked;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionDetail() {
		return descriptionDetail;
	}

	public void setDescriptionDetail(String descriptionDetail) {
		this.descriptionDetail = descriptionDetail;
	}

	public boolean isOutstanding() {
		return isOutstanding;
	}

	public void setOutstanding(boolean isOutstanding) {
		this.isOutstanding = isOutstanding;
	}

	public boolean isBestSelling() {
		return isBestSelling;
	}

	public void setBestSelling(boolean isBestSelling) {
		this.isBestSelling = isBestSelling;
	}

	public boolean isNewProduct() {
		return isNewProduct;
	}

	public void setNewProduct(boolean isNewProduct) {
		this.isNewProduct = isNewProduct;
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

	public String getBanReason() {
		return banReason;
	}

	public void setBanReason(String banReason) {
		this.banReason = banReason;
	}

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public ProductInfo(int id, Integer branchId, Integer categoryId, Integer storeId, String name, String avatar,
			String description, String descriptionDetail, boolean isOutstanding, boolean isBestSelling, boolean isNew,
			Date created, Date updated, boolean status, String banReason, Boolean isLocked) {
		super();
		this.id = id;
		this.branchId = branchId;
		this.categoryId = categoryId;
		this.storeId = storeId;
		this.name = name;
		this.avatar = avatar;
		this.description = description;
		this.descriptionDetail = descriptionDetail;
		this.isOutstanding = isOutstanding;
		this.isBestSelling = isBestSelling;
		this.isNewProduct = isNew;
		this.created = created;
		this.updated = updated;
		this.status = status;
		this.banReason = banReason;
		this.isLocked = isLocked;
	}
	
	public ProductInfo(int id, Integer branchId, String branchName, Integer categoryId, String categoryName,
			Integer storeId, String storeName, String name, String avatar, String description, String descriptionDetail,
			boolean isOutstanding, boolean isBestSelling, boolean isNew, Date created, Date updated, boolean status,
			String banReason, Boolean isLocked) {
		super();
		this.id = id;
		this.branchId = branchId;
		this.branchName = branchName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.storeId = storeId;
		this.storeName = storeName;
		this.name = name;
		this.avatar = avatar;
		this.description = description;
		this.descriptionDetail = descriptionDetail;
		this.isOutstanding = isOutstanding;
		this.isBestSelling = isBestSelling;
		this.isNewProduct = isNew;
		this.created = created;
		this.updated = updated;
		this.status = status;
		this.banReason = banReason;
		this.isLocked = isLocked;
	}

	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
