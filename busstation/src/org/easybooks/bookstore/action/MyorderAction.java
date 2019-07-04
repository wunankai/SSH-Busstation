package org.easybooks.bookstore.action;

import java.util.*;

import org.easybooks.bookstore.service.IMyorderService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MyorderAction extends ActionSupport{
	protected IMyorderService myorderService;
	private Integer userid;
	public String Myorder() throws Exception{
		Map session=ActionContext.getContext().getSession();
		List list=myorderService.UserOrdersList(userid);
		session.put("myorder",list);
		return SUCCESS;
	}
	public IMyorderService getMyorderService() {
		return myorderService;
	}
	public void setMyorderService(IMyorderService myorderService) {
		this.myorderService = myorderService;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
}
