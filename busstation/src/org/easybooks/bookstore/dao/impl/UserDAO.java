package org.easybooks.bookstore.dao.impl;
import java.util.List;
import org.easybooks.bookstore.dao.*;
import org.easybooks.bookstore.vo.User;
import org.hibernate.*;



public class UserDAO extends BaseDAO implements IUserDAO{
	public void saveUser(User user){
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
	public User validateUser(String username,String password){		
		String sql="from User u where u.username=? and u.password=?";
		Session session=getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0,username);
		query.setParameter(1,password);
		List users=query.list();
		if(users.size()!=0)
		{
			User user=(User)users.get(0);
			return user;
		}
		session.close();
		return null;
	}
	public User findUserNameById(Integer id){	
		Session session=getSession();
		String hql ="from User u where u.userId=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, id);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}
	@Override
	public List getAllUser(){
		// TODO Auto-generated method stub
		Session session=getSession();
		Query query=session.createQuery("from User u");
		List alluser=query.list();
		session.close();
		return alluser;
	}
	@Override
	public boolean exitUser(String username) {
		// TODO Auto-generated method stub
		Session session=getSession();
		String hql="from User u where u.username=?";
		Query query=session.createQuery(hql);
		query.setParameter(0,username);
		List users=query.list();
		if(users.size()!=0){
			User user=(User)users.get(0);
			return true;
		}
		session.close();
		return false;
	}
	
}

