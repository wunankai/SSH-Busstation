package org.easybooks.bookstore.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private User user;
	private Adminuser adminuser;
	private String orderTime;
	private Integer firstClassNum;
	private Integer totalNum;
	private Integer totalPrice;
	private Integer insuranceprices;
	private Timestamp refundTime;
	private String state;
	private Timestamp conversion;
	private Set orderitems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(User user, String orderTime, Integer firstClassNum, Integer totalNum, Integer totalPrice) {
		this.user = user;
		this.orderTime = orderTime;
		this.firstClassNum = firstClassNum;
		this.totalNum = totalNum;
		this.totalPrice = totalPrice;
	}

	/** full constructor */
	public Orders(User user, Adminuser adminuser, String orderTime, Integer firstClassNum, Integer totalNum,
			Integer totalPrice, Integer insuranceprices, Timestamp refundTime, String state, Timestamp conversion,
			Set orderitems) {
		this.user = user;
		this.adminuser = adminuser;
		this.orderTime = orderTime;
		this.firstClassNum = firstClassNum;
		this.totalNum = totalNum;
		this.totalPrice = totalPrice;
		this.insuranceprices = insuranceprices;
		this.refundTime = refundTime;
		this.state = state;
		this.conversion = conversion;
		this.orderitems = orderitems;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Adminuser getAdminuser() {
		return this.adminuser;
	}

	public void setAdminuser(Adminuser adminuser) {
		this.adminuser = adminuser;
	}

	public String getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getFirstClassNum() {
		return this.firstClassNum;
	}

	public void setFirstClassNum(Integer firstClassNum) {
		this.firstClassNum = firstClassNum;
	}

	public Integer getTotalNum() {
		return this.totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getInsuranceprices() {
		return this.insuranceprices;
	}

	public void setInsuranceprices(Integer insuranceprices) {
		this.insuranceprices = insuranceprices;
	}

	public Timestamp getRefundTime() {
		return this.refundTime;
	}

	public void setRefundTime(Timestamp refundTime) {
		this.refundTime = refundTime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getConversion() {
		return this.conversion;
	}

	public void setConversion(Timestamp conversion) {
		this.conversion = conversion;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

}