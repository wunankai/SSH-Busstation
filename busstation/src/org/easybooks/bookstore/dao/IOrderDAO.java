package org.easybooks.bookstore.dao;

import java.util.List;

import org.easybooks.bookstore.vo.Orders;
import org.easybooks.bookstore.vo.User;



public interface IOrderDAO {
	//保存订单信息
	public Orders saveOrder(Orders order);
	public Orders fingUserOrdersList(User user);
	public List findAllorder();
}
