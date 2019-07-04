package org.easybooks.bookstore.dao.impl;
import java.util.List;
import org.easybooks.bookstore.dao.*;
import org.hibernate.*;
public class GetinfoDAO extends BaseDAO implements IGetinfoDAO{
	//得到所有的图书类别
	public List getinformation(Integer id){
		Session session=getSession();
		Query query=session.createQuery("from Businformation b where b.bsid.id=?");
		query.setParameter(0,id);
		List getinfo=query.list();
		session.close();
		return getinfo;
	}
}
