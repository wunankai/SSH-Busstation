package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IAdminDAO;
import org.easybooks.bookstore.vo.Adminuser;
import org.hibernate.*;


public class AdminDAO extends BaseDAO implements IAdminDAO{
	public Adminuser validateadminUser(String adminName,String adminPassword){		
		String sql="from Adminuser a where a.adminName=? and a.adminPassword=?";
		Session session=getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0,adminName);
		query.setParameter(1,adminPassword);
		List admins=query.list();
		if(admins.size()!=0)
		{
			Adminuser adminuser=(Adminuser)admins.get(0);
			return adminuser;
		}
		session.close();
		return null;
	}
	
	public Adminuser findUserNameById(Integer adminId) {
		Session session=getSession();
		Adminuser adminuser=(Adminuser)session.get(Adminuser.class,adminId);
		session.close();
		return adminuser;
	}

	@Override
	public List getAllAdmin() {
		// TODO Auto-generated method stub
		Session session=getSession();
		Query query=session.createQuery("from Adminuser a");
		List admins=query.list();
		session.close();
		return admins;
	}
}
