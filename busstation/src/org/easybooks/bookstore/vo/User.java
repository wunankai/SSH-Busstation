package org.easybooks.bookstore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Adminuser adminuser;
	private String name;
	private String username;
	private String phone;
	private String password;
	private String sex;
	private String idCard;
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String username, String phone, String password, String sex, String idCard) {
		this.name = name;
		this.username = username;
		this.phone = phone;
		this.password = password;
		this.sex = sex;
		this.idCard = idCard;
	}

	/** full constructor */
	public User(Adminuser adminuser, String name, String username, String phone, String password, String sex,
			String idCard, Set orderses) {
		this.adminuser = adminuser;
		this.name = name;
		this.username = username;
		this.phone = phone;
		this.password = password;
		this.sex = sex;
		this.idCard = idCard;
		this.orderses = orderses;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Adminuser getAdminuser() {
		return this.adminuser;
	}

	public void setAdminuser(Adminuser adminuser) {
		this.adminuser = adminuser;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}