package com.demo.entities;
<<<<<<< HEAD
// Generated Nov 21, 2021, 9:53:03 AM by Hibernate Tools 5.1.10.Final
=======
// Generated Nov 23, 2021, 8:37:11 AM by Hibernate Tools 5.1.10.Final
>>>>>>> feature/manager

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contacts generated by hbm2java
 */
@Entity
<<<<<<< HEAD
@Table(name = "contacts")
=======
@Table(name = "contacts", catalog = "ecommerce_db")
>>>>>>> feature/manager
public class Contacts implements java.io.Serializable {

	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private boolean status;

	public Contacts() {
	}

	public Contacts(String name, String email, String phone, String address, boolean status) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.status = status;
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

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = false, length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address", nullable = false, length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
