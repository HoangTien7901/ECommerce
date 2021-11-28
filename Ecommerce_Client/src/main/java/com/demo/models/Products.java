package com.demo.models;

import java.util.Date;

public class Products {

	private int id;
	private int branchsID;
	private int categoryID;
	private int storesID;
	private String name;
	private String avatar;
	private String description;
	private String descriptionDetail;
	private double originalPrice;
	private Double saleOffPercent;
	private double price;
	private int quantity;
	private int inventory;
	private Date created;
	private Date updated;
	private Boolean isOutstanding;
	private Boolean isBestSelling;
	private Boolean isNew;
	private double discountPercent;
	private double discountAmount;
	private int ratingCount;
	private double ratingAverage;
	private boolean status;
	private String banReason;
	private Boolean isLocked;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBranchsID() {
		return branchsID;
	}
	public void setBranchsID(int branchsID) {
		this.branchsID = branchsID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getStoresID() {
		return storesID;
	}
	public void setStoresID(int storesID) {
		this.storesID = storesID;
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
	public double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public double getSaleOffPercent() {
		return saleOffPercent;
	}
	public void setSaleOffPercent(double saleOffPercent) {
		this.saleOffPercent = saleOffPercent;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
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
	public Boolean getIsOutstanding() {
		return isOutstanding;
	}
	public void setIsOutstanding(Boolean isOutstanding) {
		this.isOutstanding = isOutstanding;
	}
	public Boolean getIsBestSelling() {
		return isBestSelling;
	}
	public void setIsBestSelling(Boolean isBestSelling) {
		this.isBestSelling = isBestSelling;
	}
	public Boolean getIsNew() {
		return isNew;
	}
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
	public double getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public int getRatingCount() {
		return ratingCount;
	}
	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}
	public double getRatingAverage() {
		return ratingAverage;
	}
	public void setRatingAverage(double ratingAverage) {
		this.ratingAverage = ratingAverage;
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
	public Products(int id, int branchsID, int categoryID, int storesID, String name, String avatar,
			String description, String descriptionDetail, double originalPrice, double saleOffPercent, double price,
			int quantity, int inventory, Date created, Date updated, Boolean isOutstanding, Boolean isBestSelling,
			Boolean isNew, double discountPercent, double discountAmount, int ratingCount, double ratingAverage,
			boolean status, String banReason, Boolean isLocked) {
		super();
		this.id = id;
		this.branchsID = branchsID;
		this.categoryID = categoryID;
		this.storesID = storesID;
		this.name = name;
		this.avatar = avatar;
		this.description = description;
		this.descriptionDetail = descriptionDetail;
		this.originalPrice = originalPrice;
		this.saleOffPercent = saleOffPercent;
		this.price = price;
		this.quantity = quantity;
		this.inventory = inventory;
		this.created = created;
		this.updated = updated;
		this.isOutstanding = isOutstanding;
		this.isBestSelling = isBestSelling;
		this.isNew = isNew;
		this.discountPercent = discountPercent;
		this.discountAmount = discountAmount;
		this.ratingCount = ratingCount;
		this.ratingAverage = ratingAverage;
		this.status = status;
		this.banReason = banReason;
		this.isLocked = isLocked;
	}
	public Products() {
		super();
	}


}
