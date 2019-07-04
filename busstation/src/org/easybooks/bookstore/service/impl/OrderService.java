package org.easybooks.bookstore.service.impl;

import java.util.List;

import org.easybooks.bookstore.dao.IOrderDAO;
import org.easybooks.bookstore.service.IOrderService;
import org.easybooks.bookstore.vo.Orders;
import org.easybooks.bookstore.vo.User;

public class OrderService implements IOrderService{
	private IOrderDAO orderDAO;

	
	public Orders fingUserOrdersList(User user){
		return orderDAO.fingUserOrdersList(user);
	}

	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	public Orders saveOrder(Orders order) {
		
		return orderDAO.saveOrder(order);
	}

	@Override
	public List findAllorder() {
		// TODO Auto-generated method stub
		return orderDAO.findAllorder();
	}
	
}
