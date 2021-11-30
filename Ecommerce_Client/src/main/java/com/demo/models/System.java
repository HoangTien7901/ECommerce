package com.demo.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class System {

	private Integer id;
	
	@NotNull
	@Length(min = 5, max = 50)
	private String title;
	
	@NotNull
	@Min(1)
	@Max(10)
	private int bannerImgAmount;
	
	@NotNull
	@Min(1)
	@Max(10)
	private int maxBannerPhotoSize;
	
	@NotNull
	@Min(1)
	private int storeLifetime;
	
	@NotNull
	@Length(min = 10, max = 500)
	private String defaultBanEmailContent;
	
	@NotNull
	@Length(min = 10, max = 100)
	private String defaultBanEmailSubject;
	
	@NotNull
	@Length(min = 5, max = 20)
	@Pattern(regexp = "^[0-9]*$", message = "This field can only contain number.")
	private String paypalAccount;
	
	@NotNull
	@Email
	private String email;
	
	private String emailPassword;

	public System() {
	}

	public System(String title, int bannerImgAmount, int maxFileSize,int storeLifetime, String defaultBanEmailContent,
			String defaultBanEmailSubject, String paypalAccount, String email, String emailPassword) {
		this.title = title;
		this.bannerImgAmount = bannerImgAmount;
		this.maxBannerPhotoSize = maxFileSize;
		this.storeLifetime = storeLifetime;
		this.defaultBanEmailContent = defaultBanEmailContent;
		this.defaultBanEmailSubject = defaultBanEmailSubject;
		this.paypalAccount = paypalAccount;
		this.email = email;
		this.emailPassword = emailPassword;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBannerImgAmount() {
		return this.bannerImgAmount;
	}

	public void setBannerImgAmount(int bannerImgAmount) {
		this.bannerImgAmount = bannerImgAmount;
	}
	
	public int getMaxBannerPhotoSize() {
		return maxBannerPhotoSize;
	}

	public void setMaxBannerPhotoSize(int maxFileSize) {
		this.maxBannerPhotoSize = maxFileSize;
	}

	public int getStoreLifetime() {
		return this.storeLifetime;
	}

	public void setStoreLifetime(int storeLifetime) {
		this.storeLifetime = storeLifetime;
	}

	public String getDefaultBanEmailContent() {
		return this.defaultBanEmailContent;
	}

	public void setDefaultBanEmailContent(String defaultBanEmailContent) {
		this.defaultBanEmailContent = defaultBanEmailContent;
	}

	public String getDefaultBanEmailSubject() {
		return this.defaultBanEmailSubject;
	}

	public void setDefaultBanEmailSubject(String defaultBanEmailSubject) {
		this.defaultBanEmailSubject = defaultBanEmailSubject;
	}

	public String getPaypalAccount() {
		return this.paypalAccount;
	}

	public void setPaypalAccount(String paypalAccount) {
		this.paypalAccount = paypalAccount;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailPassword() {
		return this.emailPassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

}
