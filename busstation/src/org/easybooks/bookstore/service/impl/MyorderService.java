package org.easybooks.bookstore.service.impl;

import java.util.List;

import org.easybooks.bookstore.dao.IMyorderDAO;
import org.easybooks.bookstore.service.IMyorderService;


public class MyorderService implements IMyorderService{
	private IMyorderDAO myorderDAO;
	@Override
	public List UserOrdersList(Integer userid) {
		// TODO Auto-generated method stub
		return myorderDAO.UserOrdersList(userid);
	}
	public IMyorderDAO getMyorderDAO() {
		return myorderDAO;
	}
	public void setMyorderDAO(IMyorderDAO myorderDAO) {
		this.myorderDAO = myorderDAO;
	}
	
}
