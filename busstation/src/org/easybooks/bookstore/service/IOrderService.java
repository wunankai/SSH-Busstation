package org.easybooks.bookstore.service;

import java.util.List;

import org.easybooks.bookstore.vo.Orders;
import org.easybooks.bookstore.vo.User;

public interface IOrderService {
	//保存购物信息
	public Orders saveOrder(Orders order);
	public Orders fingUserOrdersList(User user);
	public List findAllorder();
}
