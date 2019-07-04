package org.easybooks.bookstore.dao.impl;

import java.util.Date;
import java.util.List;

import org.easybooks.bookstore.dao.*;
import org.easybooks.bookstore.vo.Bus;
import org.hibernate.*;

public class BusDAO extends BaseDAO implements IBusDAO {
	public List Bookingsearch(String fromcity, String tocity, Date startDate) {
	Session session=getSession();
	String queryString = "from Businformation as b where b.fromcity=? and b.tocity=? and b.startDate=?";
	Query queryObject = session.createQuery(queryString);
	queryObject.setParameter(0, fromcity);
	queryObject.setParameter(1, tocity);
	queryObject.setParameter(2, startDate );
	List bus=queryObject.list();
	session.close();
	return bus;

}

	
	public List getAllbus() {
		Session session=getSession();
		Query query=session.createQuery("from Bus b");
		List car=query.list();
		session.close();
		return car;
	}
	
	
	public void saveBus(Bus bus){
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(bus);
		tx.commit();
		session.close();
	}

	public void deleteBus(Bus bus) {
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.delete(bus);
		tx.commit();
		session.close();
	}


	
	public void updateBus(Bus bus) {
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		session.update(bus);
		ts.commit();
		session.close();	
	}

	public Bus getBusid(Integer busId) {
		Session session=getSession();
		Bus bus=(Bus)session.get(Bus.class, busId);
		session.close();
		return bus;
	}



	
	/*public void deleteBus(Integer id) {
		Session session=getSession();
		Query query=session.createQuery("delete Bus b where b.busId.id=?");
		query.setParameter(0,id);
		Transaction tx=session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		session.close();
	}*/


	
	/*public void updateBus(Integer busId) {
		Session session=getSession();
		Query query=session.createQuery("update Bus b where b.busId=?");
		query.setParameter(0,busId);
		Transaction tx=session.beginTransaction();
		query.executeUpdate();
		tx.commit();
		session.close();	
	}*/
}
