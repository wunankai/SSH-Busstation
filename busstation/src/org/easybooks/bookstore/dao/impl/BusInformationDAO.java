package org.easybooks.bookstore.dao.impl;

import java.util.List;
import org.hibernate.*;


import org.easybooks.bookstore.dao.*;
import org.easybooks.bookstore.vo.Businformation;


public class BusInformationDAO extends BaseDAO implements IBusInformationDAO{
	

	public List findAll(){
				Session session=getSession();
				String queryString = "from Businformation b";
				Query query = getSession().createQuery(queryString);
				List buses=query.list();
				session.close();
				return buses;
	}

	@Override
	public Businformation getordersinfo(Integer bus) {
		// TODO Auto-generated method stub
		Session session=getSession();
		//Hibernate返回Businformation类的持久对象
		Businformation businfo=(Businformation)session.get(Businformation.class,bus);
		session.close();
		return businfo;
	}

	public Businformation findByBusId(Integer bsid){
		Session session=getSession();
		Businformation businformation =(Businformation)session.get(Businformation.class,bsid);
		session.close();
		return businformation;
	}

	
	public void saveBusin(Businformation businformation) {
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(businformation);
		tx.commit();
		session.close();
	}

	
	public void deleteBusinfo(Integer bsid) {
		Session session=getSession();
		Query query=session.createQuery("delete Businformation b where b.bsid=?");
		query.setParameter(0,bsid);
		Transaction tx=session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		session.close();
		
	}

	
	public void updateBusinfo(Businformation businformation) {
		Session session=getSession();
		Transaction tc=session.beginTransaction();
		session.update(businformation);
		tc.commit();
		session.close();
	}

	
}
