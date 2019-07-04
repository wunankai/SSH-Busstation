package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IOrderDAO;
import org.easybooks.bookstore.vo.Orders;
import org.hibernate.*;
import org.easybooks.bookstore.vo.User;


public class OrderDAO extends BaseDAO implements IOrderDAO{
	//保存购物信息
	public Orders saveOrder(Orders order){
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(order);
		tx.commit();
		session.close();
		return order;
	}
	public Orders fingUserOrdersList(User user){
		String sql ="from Orders o where o.user=?";
		Session session=getSession();
		Query query = session.createQuery(sql);
		query.setParameter(0,user);
		List orders = query.list();
		if(orders.size()!=0)
		{
			Orders order=(Orders)orders.get(0);
			return order;
		}
		session.close();
		return null;
	}
	@Override
	public List findAllorder() {
		// TODO Auto-generated method stub
		Session session=getSession();
		String queryString = "from Orders o";
		Query query = getSession().createQuery(queryString);
		List orderlist=query.list();
		session.close();
		return orderlist;
	}
}
