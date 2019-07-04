package org.easybooks.bookstore.action;

import java.util.Map;

import org.easybooks.bookstore.service.IBusService;
import org.easybooks.bookstore.vo.*;
import com.opensymphony.xwork2.*;

public class GetordersAction extends ActionSupport{
	private Integer bus;
	private IBusService busService;
	
	public String addorders() throws Exception{
		Businformation businfo=busService.getordersinfo(bus);
		Map session=ActionContext.getContext().getSession();
		session.put("businfo",businfo);
		return SUCCESS;
		
	}
	
	public Integer getBus() {
		return bus;
	}

	public void setBus(Integer bus) {
		this.bus = bus;
	}

	public IBusService getBusService() {
		return busService;
	}

	public void setBusService(IBusService busService) {
		this.busService = busService;
	}
	
}
