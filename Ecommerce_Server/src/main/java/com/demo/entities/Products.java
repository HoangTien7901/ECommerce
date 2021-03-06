package com.demo.entities;
// Generated Nov 15, 2021, 3:44:29 PM by Hibernate Tools 5.4.30.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Products generated by hbm2java
 */
public class Products implements java.io.Serializable {

	private int id;
	private Branchs branchs;
	private Categories categories;
	private Stores stores;
	private String name;
	private String avatar;
	private String description;
	private String descriptionDetail;
	private double originalPrice;
	private double price;
	private int quantity;
	private int inventory;
	private Date created;
	private Date updated;
	private boolean isOutstanding;
	private boolean isBestSelling;
	private boolean isNew;
	private double discountPercent;
	private double discountAmount;
	private int ratingCount;
	private double ratingAverage;
	private boolean status;
	private Set tagProductses = new HashSet(0);
	private Set cartses = new HashSet(0);
	private Set imageses = new HashSet(0);
	private Set transactionses = new HashSet(0);
	private Set commentses = new HashSet(0);

	public Products() {
	}

	public Products(int id, Branchs branchs, Categories categories, Stores stores, String name, String avatar,
			String description, String descriptionDetail, double originalPrice, double price, int quantity,
			int inventory, Date created, Date updated, boolean isOutstanding, boolean isBestSelling, boolean isNew,
			double discountPercent, double discountAmount, int ratingCount, double ratingAverage, boolean status) {
		this.id = id;
		this.branchs = branchs;
		this.categories = categories;
		this.stores = stores;
		this.name = name;
		this.avatar = avatar;
		this.description = description;
		this.descriptionDetail = descriptionDetail;
		this.originalPrice = originalPrice;
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
	}

	public Products(int id, Branchs branchs, Categories categories, Stores stores, String name, String avatar,
			String description, String descriptionDetail, double originalPrice, double price, int quantity,
			int inventory, Date created, Date updated, boolean isOutstanding, boolean isBestSelling, boolean isNew,
			double discountPercent, double discountAmount, int ratingCount, double ratingAverage, boolean status,
			Set tagProductses, Set cartses, Set imageses, Set transactionses, Set commentses) {
		this.id = id;
		this.branchs = branchs;
		this.categories = categories;
		this.stores = stores;
		this.name = name;
		this.avatar = avatar;
		this.description = description;
		this.descriptionDetail = descriptionDetail;
		this.originalPrice = originalPrice;
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
		this.tagProductses = tagProductses;
		this.cartses = cartses;
		this.imageses = imageses;
		this.transactionses = transactionses;
		this.commentses = commentses;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Branchs getBranchs() {
		return this.branchs;
	}

	public void setBranchs(Branchs branchs) {
		this.branchs = branchs;
	}

	public Categories getCategories() {
		return this.categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Stores getStores() {
		return this.stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionDetail() {
		return this.descriptionDetail;
	}

	public void setDescriptionDetail(String descriptionDetail) {
		this.descriptionDetail = descriptionDetail;
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

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getInventory() {
		return this.inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
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

	public boolean isIsOutstanding() {
		return this.isOutstanding;
	}

	public void setIsOutstanding(boolean isOutstanding) {
		this.isOutstanding = isOutstanding;
	}

	public boolean isIsBestSelling() {
		return this.isBestSelling;
	}

	public void setIsBestSelling(boolean isBestSelling) {
		this.isBestSelling = isBestSelling;
	}

	public boolean isIsNew() {
		return this.isNew;
	}

	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}

	public double getDiscountPercent() {
		return this.discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public double getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getRatingCount() {
		return this.ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}

	public double getRatingAverage() {
		return this.ratingAverage;
	}

	public void setRatingAverage(double ratingAverage) {
		this.ratingAverage = ratingAverage;
	}

	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set getTagProductses() {
		return this.tagProductses;
	}

	public void setTagProductses(Set tagProductses) {
		this.tagProductses = tagProductses;
	}

	public Set getCartses() {
		return this.cartses;
	}

	public void setCartses(Set cartses) {
		this.cartses = cartses;
	}

	public Set getImageses() {
		return this.imageses;
	}

	public void setImageses(Set imageses) {
		this.imageses = imageses;
	}

	public Set getTransactionses() {
		return this.transactionses;
	}

	public void setTransactionses(Set transactionses) {
		this.transactionses = transactionses;
	}

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

}
