package org.easybooks.bookstore.vo;

/**
 * Bus entity. @author MyEclipse Persistence Tools
 */

public class Bus implements java.io.Serializable {

	// Fields

	private Integer busId;
	private Adminuser adminuser;
	private String busesclass;
	private String drivername;
	private String driverphone;
	private Integer numbers;
	private String remark;

	// Constructors

	/** default constructor */
	public Bus() {
	}

	/** minimal constructor */
	public Bus(String busesclass, String drivername, String driverphone, Integer numbers) {
		this.busesclass = busesclass;
		this.drivername = drivername;
		this.driverphone = driverphone;
		this.numbers = numbers;
	}

	/** full constructor */
	public Bus(Adminuser adminuser, String busesclass, String drivername, String driverphone, Integer numbers,
			String remark) {
		this.adminuser = adminuser;
		this.busesclass = busesclass;
		this.drivername = drivername;
		this.driverphone = driverphone;
		this.numbers = numbers;
		this.remark = remark;
	}

	// Property accessors

	public Integer getBusId() {
		return this.busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public Adminuser getAdminuser() {
		return this.adminuser;
	}

	public void setAdminuser(Adminuser adminuser) {
		this.adminuser = adminuser;
	}

	public String getBusesclass() {
		return this.busesclass;
	}

	public void setBusesclass(String busesclass) {
		this.busesclass = busesclass;
	}

	public String getDrivername() {
		return this.drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public String getDriverphone() {
		return this.driverphone;
	}

	public void setDriverphone(String driverphone) {
		this.driverphone = driverphone;
	}

	public Integer getNumbers() {
		return this.numbers;
	}

	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}