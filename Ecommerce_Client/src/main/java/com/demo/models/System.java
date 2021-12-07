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
	@Length(min = 10, max = 500)
	private String defaultBanEmailContent;
	
	@NotNull
	@Length(min = 10, max = 100)
	private String defaultBanEmailSubject;
	
	@NotNull
	@Length(min = 10, max = 500)
	private String defaultPasswordEmailContent;
	
	@NotNull
	@Length(min = 10, max = 100)
	private String defaultPasswordEmailSubject;
	
	@NotNull
	@Email
	private String paypalAccount;
	
	@NotNull
	@Email
	private String email;
	
	private String emailPassword;

	public System() {
	}

	public System(String title, int bannerImgAmount, int maxFileSize, String defaultBanEmailContent,
			String defaultBanEmailSubject, String defaultPasswordEmailContent,
			String defaultPasswordEmailSubject,String paypalAccount, String email, String emailPassword) {
		this.title = title;
		this.bannerImgAmount = bannerImgAmount;
		this.maxBannerPhotoSize = maxFileSize;
		this.defaultBanEmailContent = defaultBanEmailContent;
		this.defaultBanEmailSubject = defaultBanEmailSubject;
		this.defaultPasswordEmailContent = defaultPasswordEmailContent;
		this.defaultPasswordEmailSubject = defaultPasswordEmailSubject;
		this.paypalAccount = paypalAccount;
		this.email = email;
		this.emailPassword = emailPassword;
	}

	public String getDefaultPasswordEmailContent() {
		return defaultPasswordEmailContent;
	}

	public void setDefaultPasswordEmailContent(String defaultPasswordEmailContent) {
		this.defaultPasswordEmailContent = defaultPasswordEmailContent;
	}

	public String getDefaultPasswordEmailSubject() {
		return defaultPasswordEmailSubject;
	}

	public void setDefaultPasswordEmailSubject(String defaultPasswordEmailSubject) {
		this.defaultPasswordEmailSubject = defaultPasswordEmailSubject;
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
