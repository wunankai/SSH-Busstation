package org.easybooks.bookstore.service.impl;
import java.util.List;

import org.easybooks.bookstore.dao.IGetinfoDAO;
import org.easybooks.bookstore.service.IGetinfoService;
public class GetinfoService implements IGetinfoService{
	private IGetinfoDAO getinfoDAO;
	//通过id得到生成订单信息
	public List getinformation(Integer id){
		return getinfoDAO.getinformation(id);
	}
	public IGetinfoDAO getGetinfoDAO() {
		return getinfoDAO;
	}
	public void setGetinfoDAO(IGetinfoDAO getinfoDAO) {
		this.getinfoDAO = getinfoDAO;
	}

}
