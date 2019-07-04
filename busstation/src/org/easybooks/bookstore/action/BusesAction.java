package org.easybooks.bookstore.action;

import java.util.*;

import org.easybooks.bookstore.service.IAdminService;
import org.easybooks.bookstore.service.IBusesService;
import org.easybooks.bookstore.vo.Bus;
import org.easybooks.bookstore.vo.Businformation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BusesAction extends ActionSupport{
	protected String fromcity;
	protected String tocity;
	protected Date startDate;
	private Integer id;
	private Businformation businfo;
	private Integer busId;
	private Bus bus;
	private Integer adminId;
	private String result;
	protected IBusesService busesService;
	protected IAdminService adminService;
	/**
	 * 查询用户所搜索的车票
	 */
	@SuppressWarnings("unchecked")
	public String bookingTickets() throws Exception{
		List busquery=busesService.BookingQuery(businfo);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("binfor",busquery);
		return SUCCESS;
		
	} 
	public String searchAllcar() throws Exception{
		List car=busesService.getAllbus();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("car",car);
		return SUCCESS;
	}
	public String saveNewCar() throws Exception{
		//Adminuser adminuser=adminService.findUserNameById(adminId);
		//Bus bus =new Bus();
		//bus.setAdminuser(adminuser);
		busesService.saveBus(bus);
		//this.setResult("saveNewCarSuccess");
		return SUCCESS;
		//return SUCCESS;
	}
	public String deleBus() throws Exception{
		Bus bus=busesService.getBusid(busId);
		busesService.deleteBus(bus);
		//this.setResult("delPlaneSuccess");
		return SUCCESS;
	}
	
	public String updaBus() throws Exception{
		Bus b=busesService.getBusid(bus.getBusId());
		System.out.println(b);
		busesService.updateBus(bus);
		this.setResult("updatePlaneSuccess");
		return SUCCESS;
	}
	public IAdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	public IBusesService getBusesService() {
		return busesService;
	}
	public void setBusesService(IBusesService busesService) {
		this.busesService = busesService;
	}
	
	public String getFromcity() {
		return fromcity;
	}
	public void setFromcity(String fromcity) {
		this.fromcity = fromcity;
	}
	public String getTocity() {
		return tocity;
	}
	public void setTocity(String tocity) {
		this.tocity = tocity;
	}
	public Date getStartDate() {
	return startDate;
	}
	public void setStartDate(Date startDate) {
	this.startDate = startDate;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBusId() {
		return busId;
	}
	public void setBusId(Integer busId) {
		this.busId = busId;
	}
	public Businformation getBusinfo() {
		return businfo;
	}
	public void setBusinfo(Businformation businfo) {
		this.businfo = businfo;
	}
	
}
