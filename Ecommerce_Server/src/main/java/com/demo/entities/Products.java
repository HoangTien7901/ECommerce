package com.demo.entities;
// Generated Nov 23, 2021, 8:37:11 AM by Hibernate Tools 5.1.10.Final

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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "products", catalog = "ecommerce_db")
public class Products implements java.io.Serializable {

	private Integer id;
	private Branchs branchs;
	private Categories categories;
	private Stores stores;
	private String name;
	private String avatar;
	private String description;
	private String descriptionDetail;
	private double originalPrice;
	private Double saleOffPercent;
	private double price;
	private int quantity;
	private int inventory;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
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
	private Set<Images> imageses = new HashSet<Images>(0);
	private Set<Comments> commentses = new HashSet<Comments>(0);
	private Set<TagProducts> tagProductses = new HashSet<TagProducts>(0);
	private Set<CartProduct> cartProducts = new HashSet<CartProduct>(0);
	private Set<Transactions> transactionses = new HashSet<Transactions>(0);

	public Products() {
	}

	public Products(Branchs branchs, Categories categories, Stores stores, String name, String avatar,
			String description, String descriptionDetail, double originalPrice, double price, int quantity,
			int inventory, Date created, double discountPercent, double discountAmount, int ratingCount,
			double ratingAverage, boolean status) {
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
		this.discountPercent = discountPercent;
		this.discountAmount = discountAmount;
		this.ratingCount = ratingCount;
		this.ratingAverage = ratingAverage;
		this.status = status;
	}

	public Products(Branchs branchs, Categories categories, Stores stores, String name, String avatar,
			String description, String descriptionDetail, double originalPrice, Double saleOffPercent, double price,
			int quantity, int inventory, Date created, Date updated, Boolean isOutstanding, Boolean isBestSelling,
			Boolean isNew, double discountPercent, double discountAmount, int ratingCount, double ratingAverage,
			boolean status, String banReason, Boolean isLocked, Set<Images> imageses, Set<Comments> commentses,
			Set<TagProducts> tagProductses, Set<CartProduct> cartProducts, Set<Transactions> transactionses) {
		this.branchs = branchs;
		this.categories = categories;
		this.stores = stores;
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
		this.imageses = imageses;
		this.commentses = commentses;
		this.tagProductses = tagProductses;
		this.cartProducts = cartProducts;
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
	@JoinColumn(name = "branch_id", nullable = false)
	public Branchs getBranchs() {
		return this.branchs;
	}

	public void setBranchs(Branchs branchs) {
		this.branchs = branchs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Categories getCategories() {
		return this.categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id", nullable = false)
	public Stores getStores() {
		return this.stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}

	@Column(name = "name", nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "avatar", nullable = false, length = 100)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "description", nullable = false, length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "description_detail", nullable = false, length = 65535)
	public String getDescriptionDetail() {
		return this.descriptionDetail;
	}

	public void setDescriptionDetail(String descriptionDetail) {
		this.descriptionDetail = descriptionDetail;
	}

	@Column(name = "original_price", nullable = false, precision = 22, scale = 0)
	public double getOriginalPrice() {
		return this.originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	@Column(name = "sale_off_percent", precision = 22, scale = 0)
	public Double getSaleOffPercent() {
		return this.saleOffPercent;
	}

	public void setSaleOffPercent(Double saleOffPercent) {
		this.saleOffPercent = saleOffPercent;
	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "inventory", nullable = false)
	public int getInventory() {
		return this.inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
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

	@Column(name = "is_outstanding")
	public Boolean getIsOutstanding() {
		return this.isOutstanding;
	}

	public void setIsOutstanding(Boolean isOutstanding) {
		this.isOutstanding = isOutstanding;
	}

	@Column(name = "is_best_selling")
	public Boolean getIsBestSelling() {
		return this.isBestSelling;
	}

	public void setIsBestSelling(Boolean isBestSelling) {
		this.isBestSelling = isBestSelling;
	}

	@Column(name = "is_new")
	public Boolean getIsNew() {
		return this.isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	@Column(name = "discount_percent", nullable = false, precision = 22, scale = 0)
	public double getDiscountPercent() {
		return this.discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	@Column(name = "discount_amount", nullable = false, precision = 22, scale = 0)
	public double getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Column(name = "rating_count", nullable = false)
	public int getRatingCount() {
		return this.ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}

	@Column(name = "rating_average", nullable = false, precision = 22, scale = 0)
	public double getRatingAverage() {
		return this.ratingAverage;
	}

	public void setRatingAverage(double ratingAverage) {
		this.ratingAverage = ratingAverage;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "ban_reason", length = 65535)
	public String getBanReason() {
		return this.banReason;
	}

	public void setBanReason(String banReason) {
		this.banReason = banReason;
	}

	@Column(name = "is_locked")
	public Boolean getIsLocked() {
		return this.isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Images> getImageses() {
		return this.imageses;
	}

	public void setImageses(Set<Images> imageses) {
		this.imageses = imageses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Comments> getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set<Comments> commentses) {
		this.commentses = commentses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<TagProducts> getTagProductses() {
		return this.tagProductses;
	}

	public void setTagProductses(Set<TagProducts> tagProductses) {
		this.tagProductses = tagProductses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<CartProduct> getCartProducts() {
		return this.cartProducts;
	}

	public void setCartProducts(Set<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Transactions> getTransactionses() {
		return this.transactionses;
	}

	public void setTransactionses(Set<Transactions> transactionses) {
		this.transactionses = transactionses;
	}

}
