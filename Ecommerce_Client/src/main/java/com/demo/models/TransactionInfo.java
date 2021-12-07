package com.demo.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Admin
 *
 */
public class TransactionInfo {
	private int id;
	private Integer productId;
	private String productName;
	private String categoryName;
	private String branchName;
	private Integer serviceId;
	private String serviceName;
	private String storeName;
	private String username;
	private double price;
	private int quantity;
	private double tax;
	private String note;
	private String status;
	private String cancelReason;
	private int transactionDetailsId;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;

	public int getTransactionDetailsId() {
		return transactionDetailsId;
	}

	public void setTransactionDetailsId(int transactionDetailsId) {
		this.transactionDetailsId = transactionDetailsId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
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

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public TransactionInfo(int id, Integer productId, Integer serviceId, String storeName, double price, int quantity,
			double tax, String note, String status, String cancelReason) {
		super();
		this.id = id;
		this.productId = productId;
		this.serviceId = serviceId;
		this.storeName = storeName;
		this.price = price;
		this.quantity = quantity;
		this.tax = tax;
		this.note = note;
		this.status = status;
		this.cancelReason = cancelReason;
	}

	// for service transaction list
	public TransactionInfo(int id, Integer serviceId, String serviceName, String storeName, double price, int quantity,
			double tax, String status, String cancelReason, Date created) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.serviceId = serviceId;
		this.storeName = storeName;
		this.price = price;
		this.quantity = quantity;
		this.tax = tax;
		this.status = status;
		this.cancelReason = cancelReason;
		this.created = created;
	}

	// for buying
	public TransactionInfo(int id, Integer productId, String productName, String categoryName, String username,
			double price, int quantity, String status, int transactionDetailsId, Date created) {
		super();
		this.id = id;
		this.productName = productName;
		this.productId = productId;
		this.username = username;
		this.categoryName = categoryName;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.created = created;
		this.transactionDetailsId = transactionDetailsId;
	}

	// for product transaction list
	public TransactionInfo(int id, Integer productId, String productName, String categoryName, String branchName,
			String username, double price, int quantity, double tax, String status, String cancelReason, Date created) {
		super();
		this.id = id;
		this.productName = productName;
		this.productId = productId;
		this.username = username;
		this.categoryName = categoryName;
		this.branchName = branchName;
		this.price = price;
		this.quantity = quantity;
		this.tax = tax;
		this.status = status;
		this.cancelReason = cancelReason;
		this.created = created;
	}

	public TransactionInfo() {
		super();
	}

}
