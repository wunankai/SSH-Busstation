package org.easybooks.bookstore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Adminuser entity. @author MyEclipse Persistence Tools
 */

public class Adminuser implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String adminName;
	private String adminPassword;
	private String adminPhone;
	private Set users = new HashSet(0);
	private Set buses = new HashSet(0);
	private Set orderses = new HashSet(0);
	private Set businformations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Adminuser() {
	}

	/** minimal constructor */
	public Adminuser(String adminName, String adminPassword, String adminPhone) {
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminPhone = adminPhone;
	}

	/** full constructor */
	public Adminuser(String adminName, String adminPassword, String adminPhone, Set users, Set buses, Set orderses,
			Set businformations) {
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminPhone = adminPhone;
		this.users = users;
		this.buses = buses;
		this.orderses = orderses;
		this.businformations = businformations;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminPhone() {
		return this.adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getBuses() {
		return this.buses;
	}

	public void setBuses(Set buses) {
		this.buses = buses;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getBusinformations() {
		return this.businformations;
	}

	public void setBusinformations(Set businformations) {
		this.businformations = businformations;
	}

}