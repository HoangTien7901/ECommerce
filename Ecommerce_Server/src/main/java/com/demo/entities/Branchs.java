package com.demo.entities;
// Generated Nov 21, 2021, 9:53:03 AM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Branchs generated by hbm2java
 */
@Entity
@Table(name = "branchs")
public class Branchs implements java.io.Serializable {

	private Integer id;
	private String name;
	private String logo;
	private Set<Products> productses = new HashSet<Products>(0);

	public Branchs() {
	}

	public Branchs(String name, String logo) {
		this.name = name;
		this.logo = logo;
	}

	public Branchs(String name, String logo, Set<Products> productses) {
		this.name = name;
		this.logo = logo;
		this.productses = productses;
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

	@Column(name = "logo", nullable = false, length = 100)
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "branchs")
	public Set<Products> getProductses() {
		return this.productses;
	}

	public void setProductses(Set<Products> productses) {
		this.productses = productses;
	}

}
