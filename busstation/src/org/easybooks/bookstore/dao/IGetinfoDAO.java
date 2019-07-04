package org.easybooks.bookstore.dao;
import java.util.List;
public interface IGetinfoDAO {
	//通过busId获得生成订单信息
	public List getinformation(Integer id);
}
