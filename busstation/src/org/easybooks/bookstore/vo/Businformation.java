package org.easybooks.bookstore.vo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Businformation entity. @author MyEclipse Persistence Tools
 */

public class Businformation implements java.io.Serializable {

	// Fields

	private Integer bsid;
	private Adminuser adminuser;
	private String busid;
	private Date startDate;
	private Date startTime;
	private String fromcity;
	private String tocity;
	private String fromTerminal;
	private String toTerminal;
	private String banciId;
	private String spendTime;
	private String busclass;
	private Integer price;
	private Integer remain;
	private Set orderitems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Businformation() {
	}

	/** minimal constructor */
	public Businformation(String busid, Date startDate, Date startTime, String fromcity, String tocity,
			String fromTerminal, String toTerminal, String banciId, String spendTime, String busclass, Integer price,
			Integer remain) {
		this.busid = busid;
		this.startDate = startDate;
		this.startTime = startTime;
		this.fromcity = fromcity;
		this.tocity = tocity;
		this.fromTerminal = fromTerminal;
		this.toTerminal = toTerminal;
		this.banciId = banciId;
		this.spendTime = spendTime;
		this.busclass = busclass;
		this.price = price;
		this.remain = remain;
	}

	/** full constructor */
	public Businformation(Adminuser adminuser, String busid, Date startDate, Date startTime, String fromcity,
			String tocity, String fromTerminal, String toTerminal, String banciId, String spendTime, String busclass,
			Integer price, Integer remain, Set orderitems) {
		this.adminuser = adminuser;
		this.busid = busid;
		this.startDate = startDate;
		this.startTime = startTime;
		this.fromcity = fromcity;
		this.tocity = tocity;
		this.fromTerminal = fromTerminal;
		this.toTerminal = toTerminal;
		this.banciId = banciId;
		this.spendTime = spendTime;
		this.busclass = busclass;
		this.price = price;
		this.remain = remain;
		this.orderitems = orderitems;
	}

	// Property accessors

	public Integer getBsid() {
		return this.bsid;
	}

	public void setBsid(Integer bsid) {
		this.bsid = bsid;
	}

	public Adminuser getAdminuser() {
		return this.adminuser;
	}

	public void setAdminuser(Adminuser adminuser) {
		this.adminuser = adminuser;
	}

	public String getBusid() {
		return this.busid;
	}

	public void setBusid(String busid) {
		this.busid = busid;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getFromcity() {
		return this.fromcity;
	}

	public void setFromcity(String fromcity) {
		this.fromcity = fromcity;
	}

	public String getTocity() {
		return this.tocity;
	}

	public void setTocity(String tocity) {
		this.tocity = tocity;
	}

	public String getFromTerminal() {
		return this.fromTerminal;
	}

	public void setFromTerminal(String fromTerminal) {
		this.fromTerminal = fromTerminal;
	}

	public String getToTerminal() {
		return this.toTerminal;
	}

	public void setToTerminal(String toTerminal) {
		this.toTerminal = toTerminal;
	}

	public String getBanciId() {
		return this.banciId;
	}

	public void setBanciId(String banciId) {
		this.banciId = banciId;
	}

	public String getSpendTime() {
		return this.spendTime;
	}

	public void setSpendTime(String spendTime) {
		this.spendTime = spendTime;
	}

	public String getBusclass() {
		return this.busclass;
	}

	public void setBusclass(String busclass) {
		this.busclass = busclass;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getRemain() {
		return this.remain;
	}

	public void setRemain(Integer remain) {
		this.remain = remain;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

}