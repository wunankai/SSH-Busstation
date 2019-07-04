package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IMyorderDAO;
import org.hibernate.Query;
import org.hibernate.Session;

public class MyorderDAO extends BaseDAO implements IMyorderDAO{
	public List UserOrdersList(Integer userid){
		String sql ="from Businformation b,User u,Orders o where o.user.userid=? and o.user=u.userId and b.banciId=o.businformation";
		Session session=getSession();
		Query query = session.createQuery(sql);
		query.setParameter(0,userid);
		List list = query.list();
		session.close();
		return list;
	}
}
