package com.demo.entities;
// Generated Nov 30, 2021, 8:56:15 AM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * System generated by hbm2java
 */
@Entity
@Table(name = "system", catalog = "ecommerce_db")
public class System implements java.io.Serializable {

	private Integer id;
	private String title;
	private int bannerImgAmount;
	private int maxBannerPhotoSize;
	private String defaultBanEmailContent;
	private String defaultBanEmailSubject;
	private String defaultPasswordEmailContent;
	private String defaultPasswordEmailSubject;
	private String paypalAccount;
	private String email;
	private String emailPassword;

	public System() {
	}
	
	public System(Integer id, String title, int bannerImgAmount, int maxBannerPhotoSize, 
			String defaultBanEmailContent, String defaultBanEmailSubject, String defaultPasswordEmailContent,
			String defaultPasswordEmailSubject, String paypalAccount, String email, String emailPassword) {
		super();
		this.id = id;
		this.title = title;
		this.bannerImgAmount = bannerImgAmount;
		this.maxBannerPhotoSize = maxBannerPhotoSize;
		this.defaultBanEmailContent = defaultBanEmailContent;
		this.defaultBanEmailSubject = defaultBanEmailSubject;
		this.defaultPasswordEmailContent = defaultPasswordEmailContent;
		this.defaultPasswordEmailSubject = defaultPasswordEmailSubject;
		this.paypalAccount = paypalAccount;
		this.email = email;
		this.emailPassword = emailPassword;
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

	@Column(name = "title", nullable = false, length = 250)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "banner_img_amount", nullable = false)
	public int getBannerImgAmount() {
		return this.bannerImgAmount;
	}

	public void setBannerImgAmount(int bannerImgAmount) {
		this.bannerImgAmount = bannerImgAmount;
	}
	
	@Column(name = "max_banner_photo_size", nullable = false)
	public int getMaxBannerPhotoSize() {
		return this.maxBannerPhotoSize;
	}

	public void setMaxBannerPhotoSize(int maxBannerPhotoSize) {
		this.maxBannerPhotoSize = maxBannerPhotoSize;
	}

	@Column(name = "default_ban_email_content", nullable = false, length = 65535)
	public String getDefaultBanEmailContent() {
		return this.defaultBanEmailContent;
	}

	public void setDefaultBanEmailContent(String defaultBanEmailContent) {
		this.defaultBanEmailContent = defaultBanEmailContent;
	}

	@Column(name = "default_ban_email_subject", nullable = false, length = 200)
	public String getDefaultBanEmailSubject() {
		return this.defaultBanEmailSubject;
	}

	public void setDefaultBanEmailSubject(String defaultBanEmailSubject) {
		this.defaultBanEmailSubject = defaultBanEmailSubject;
	}
	// =======================
	@Column(name = "default_password_email_content", nullable = false, length = 65535)
	public String getDefaultPasswordEmailContent() {
		return this.defaultPasswordEmailContent;
	}

	public void setDefaultPasswordEmailContent(String defaultPasswordEmailContent) {
		this.defaultPasswordEmailContent = defaultPasswordEmailContent;
	}

	@Column(name = "default_password_email_subject", nullable = false, length = 200)
	public String getDefaultPasswordEmailSubject() {
		return this.defaultPasswordEmailSubject;
	}

	public void setDefaultPasswordEmailSubject(String defaultPasswordEmailSubject) {
		this.defaultPasswordEmailSubject = defaultPasswordEmailSubject;
	}

	@Column(name = "paypal_account", nullable = false, length = 100)
	public String getPaypalAccount() {
		return this.paypalAccount;
	}

	public void setPaypalAccount(String paypalAccount) {
		this.paypalAccount = paypalAccount;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "email_password", nullable = false, length = 100)
	public String getEmailPassword() {
		return this.emailPassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

}