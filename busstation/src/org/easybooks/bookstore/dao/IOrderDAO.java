package org.easybooks.bookstore.dao;

import java.util.List;

import org.easybooks.bookstore.vo.Orders;
import org.easybooks.bookstore.vo.User;



public interface IOrderDAO {
	//���涩����Ϣ
	public Orders saveOrder(Orders order);
	public Orders fingUserOrdersList(User user);
	public List findAllorder();
}
